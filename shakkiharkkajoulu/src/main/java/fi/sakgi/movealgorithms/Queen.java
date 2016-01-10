package fi.sakgi.movealgorithms;

import static fi.sakgi.game.Board.board;
import static fi.sakgi.movealgorithms.KingSafety.kingIsSafe;

/**
 * Kuningattaren liikkumisalgoritmi
 *
 * @author sampe
 */
public class Queen {

    /**
     * r kertoo rivin, missa nappula sijaitsee, c sarakkeen. temp:ia
     * kasvatetaan, kun kaydaan ruutuja lapi, etta saadaan ylos kaikki
     * mahdolliset tyhjat ruudut
     */
    static int r, c, temp;
    /**
     * oldpiece pitaa vanhaa nappulaa muistissa, list on palautettava lista,
     * jossa on kaikki mahdolliset siirrot kyseiselle nappulalle.
     */
    static String oldPiece, list = "";

    /**
     * Metodi palauttaa laudalla sijaitsevan kuningattaren kaikki mahdolliset
     * siirrot. Parametri i kertoo metodille, missä nappula sijaitsee.
     *
     * @param i
     * @return
     */
    public static String legalQueenMoves(int i) {

        r = i / 8;
        c = i % 8;
        temp = 1;
        for (int j = -1; j <= 1; j++) {
            for (int k = -1; k <= 1; k++) {
                if (j != 0 || k != 0) {
                    try {
                        isSquareEmpty(j, k);
                        isOpponentPieceNext(j, k);
                    } catch (Exception e) {
                    }
                    temp = 1;
                }
            }
        }
        return list;
    }

    /**
     * tarkastaako onko seuraava nappula vastustajan
     *
     * @param j
     * @param k
     * @param temp
     */
    public static void isOpponentPieceNext(int j, int k) {
        if (Character.isLowerCase(board[r + temp * j][c + temp * k].charAt(0))) {
            oldPiece = board[r + temp * j][c + temp * k];
            board[r][c] = " ";
            board[r + temp * j][c + temp * k] = "Q";
            if (kingIsSafe()) {
                list = list + r + c + (r + temp * j) + (c + temp * k) + oldPiece;
            }
            board[r][c] = "Q";
            board[r + temp * j][c + temp * k] = oldPiece;
        }
    }

    /**
     * tarkastaako on seuraava mahdollinen ruutu tyhjä
     *
     * @param j
     * @param k
     */
    public static void isSquareEmpty(int j, int k) {
        while (" ".equals(board[r + temp * j][c + temp * k])) {
            oldPiece = board[r + temp * j][c + temp * k];
            board[r][c] = " ";
            board[r + temp * j][c + temp * k] = "Q";
            if (kingIsSafe()) {
                list = list + r + c + (r + temp * j) + (c + temp * k) + oldPiece;
            }
            board[r][c] = "Q";
            board[r + temp * j][c + temp * k] = oldPiece;
            temp++;
        }
    }
}
