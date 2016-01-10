package fi.sakgi.movealgorithms;

import static fi.sakgi.game.Board.board;
import static fi.sakgi.movealgorithms.KingSafety.kingIsSafe;

/**
 * Tornin liikkumisalgoritmi
 *
 * @author sampe
 */
public class Rook {

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
     * Metodi palauttaa laudalla sijaitsevan tornin kaikki mahdolliset siirrot.
     * Parametri i kertoo metodille, missä nappula sijaitsee.
     *
     * @param i
     * @return
     */
    public static String legalRookMoves(int i) {

        r = i / 8;
        c = i % 8;
        temp = 1;
        for (int j = -1; j <= 1; j += 2) {
            try {
                checkDiagonal(j);
                isNextOpponentDiag(j);
            } catch (Exception e) {
            }
            temp = 1;
            try {
                checkHorizontal(j);
                isNextOpponentHoriz(j);
            } catch (Exception e) {
            }
            temp = 1;
        }
        return list;
    }

    /**
     * tarkastaako onko seuraavalla ruudulla vastustaja(vaakatasossa
     * liikuttaessa)
     *
     * @param j
     */
    public static void isNextOpponentDiag(int j) {
        if (Character.isLowerCase(board[r][c + temp * j].charAt(0))) {
            oldPiece = board[r][c + temp * j];
            board[r][c] = " ";
            board[r][c + temp * j] = "R";
            if (kingIsSafe()) {
                list = list + r + c + r + (c + temp * j) + oldPiece;
            }
            board[r][c] = "R";
            board[r][c + temp * j] = oldPiece;
        }
    }

    /**
     * katsoo vaakatason ruudut läpi
     *
     * @param j
     */
    public static void checkDiagonal(int j) {
        while (" ".equals(board[r][c + temp * j])) {
            oldPiece = board[r][c + temp * j];
            board[r][c] = " ";
            board[r][c + temp * j] = "R";
            if (kingIsSafe()) {
                list = list + r + c + r + (c + temp * j) + oldPiece;
            }
            board[r][c] = "R";
            board[r][c + temp * j] = oldPiece;
            temp++;
        }
    }

    /**
     * katsoo pystytason ruudut läpi
     *
     * @param j
     */
    public static void checkHorizontal(int j) {
        while (" ".equals(board[r + temp * j][c])) {
            oldPiece = board[r + temp * j][c];
            board[r][c] = " ";
            board[r + temp * j][c] = "R";
            if (kingIsSafe()) {
                list = list + r + c + (r + temp * j) + c + oldPiece;
            }
            board[r][c] = "R";
            board[r + temp * j][c] = oldPiece;
            temp++;
        }
    }

    /**
     * katsoo onko seuraavavalla ruudulla vastus
     *
     * @param j
     */
    public static void isNextOpponentHoriz(int j) {
        if (Character.isLowerCase(board[r + temp * j][c].charAt(0))) {
            oldPiece = board[r + temp * j][c];
            board[r][c] = " ";
            board[r + temp * j][c] = "R";
            if (kingIsSafe()) {
                list = list + r + c + (r + temp * j) + c + oldPiece;
            }
            board[r][c] = "R";
            board[r + temp * j][c] = oldPiece;
        }
    }
}
