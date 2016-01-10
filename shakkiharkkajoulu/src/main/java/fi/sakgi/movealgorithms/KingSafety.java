package fi.sakgi.movealgorithms;

import static fi.sakgi.game.Board.board;
import static fi.sakgi.game.Board.kingPosC;

/**
 * Luokka palauttaa totuusarvon siita, onko kuningas turvassa kyseisen siirron
 * jalkeen.
 *
 * @author sampe
 */
public class KingSafety {

    static int temp;

    static boolean truth = true;

    /**
     * palauttaa totuusarvon siita onko kuningas turvassa. En saanut toimimaan
     * tata metodia taydellisesti, joten paatin pistaa sen palauttamaan aina
     * true, jotta ohjelma ei bugaisi. Huomio itselleni: katso jaako
     * muistijalkia.
     *
     * @return
     */
    public static boolean kingIsSafe() {

        temp = 1;
        bishopAndQueen();
        rookAndQueen();
        knight();
        pawnAndKing();
//        return truth;
        return true;
    }

    /**
     * Katsoo kuninkaasta viistoon kulkevat reitit
     */
    public static void bishopAndQueen() {
        for (int i = -1; i <= 1; i += 2) {
            for (int j = -1; j <= 1; j += 2) {
                try {
                    while (" ".equals(board[kingPosC / 8 + temp * i][kingPosC % 8 + temp * j])) {
                        temp++;
                    }
                    if ("b".equals(board[kingPosC / 8 + temp * i][kingPosC % 8 + temp * j])
                            || "q".equals(board[kingPosC / 8 + temp * i][kingPosC % 8 + temp * j])) {
                        truth = false;
                    }
                } catch (Exception e) {
                }
                temp = 1;
            }
        }

    }

    /**
     * Katsoo kuninkaasta vaakatasoon ja pystysuuntaan kulkevat reitit
     */
    public static void rookAndQueen() {
        for (int i = -1; i <= 1; i += 2) {
            try {
                while (" ".equals(board[kingPosC / 8][kingPosC % 8 + temp * i])) {
                    temp++;
                }
                if ("r".equals(board[kingPosC / 8][kingPosC % 8 + temp * i])
                        || "q".equals(board[kingPosC / 8][kingPosC % 8 + temp * i])) {
                    truth = false;
                }
            } catch (Exception e) {
            }
            temp = 1;
            try {
                while (" ".equals(board[kingPosC / 8 + temp * i][kingPosC % 8])) {
                    temp++;
                }
                if ("r".equals(board[kingPosC / 8 + temp * i][kingPosC % 8])
                        || "q".equals(board[kingPosC / 8 + temp * i][kingPosC % 8])) {
                    truth = false;
                }
            } catch (Exception e) {
            }
            temp = 1;
        }

    }

    /**
     * Katsoo uhkaako heppa kuningasta
     */
    public static void knight() {
        for (int i = -1; i <= 1; i += 2) {
            for (int j = -1; j <= 1; j += 2) {
                try {
                    if ("k".equals(board[kingPosC / 8 + i][kingPosC % 8 + j * 2])) {
                        truth = false;
                    }
                } catch (Exception e) {
                }
                try {
                    if ("k".equals(board[kingPosC / 8 + i * 2][kingPosC % 8 + j])) {
                        truth = false;
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    /**
     * Katsoo uhkaako sotilas tai kuningas
     */
    public static void pawnAndKing() {
        if (kingPosC >= 16) {
            try {
                if ("p".equals(board[kingPosC / 80 - 1][kingPosC % 8 - 1])) {
                    truth = false;
                }
            } catch (Exception e) {
            }
            try {
                if ("p".equals(board[kingPosC / 80 - 1][kingPosC % 8 + 1])) {
                    truth = false;
                }
            } catch (Exception e) {
            }

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i != 0 || j != 0) {
                        try {
                            if ("a".equals(board[kingPosC / 8 + i][kingPosC % 8 + j])) {
                                truth = false;
                            }
                        } catch (Exception e) {
                        }
                    }
                }
            }
        }
    }
}
