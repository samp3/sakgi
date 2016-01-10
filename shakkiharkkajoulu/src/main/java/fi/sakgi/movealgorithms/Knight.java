package fi.sakgi.movealgorithms;

import static fi.sakgi.game.Board.board;
import static fi.sakgi.movealgorithms.KingSafety.kingIsSafe;

/**
 * Hepan liikkumisalgoritmi
 *
 * @author sampe
 */
public class Knight {

    /**
     * r kertoo rivin, missa nappula sijaitsee, c sarakkeen.
     */
    static int r, c;

    /* * oldpiece pitaa vanhaa nappulaa(joka syodaan)
     * muistissa, list on palautettava lista, jossa on kaikki mahdolliset siirrot kyseiselle
     * nappulalle.
     */
    static String oldPiece, list = "";

    /**
     * Metodi palauttaa laudalla sijaitsevan hevosen kaikki mahdolliset siirrot.
     * Parametri i kertoo metodille, missä nappula sijaitsee.
     *
     * @param i
     * @return
     */
    public static String legalKnightMoves(int i) {
        r = i / 8;
        c = i % 8;
        for (int j = -1; j <= 1; j += 2) {
            for (int k = -1; k <= 1; k += 2) {
                verticalMovement(j, k);
                horizontalMovement(j, k);
            }
        }
        return list;
    }

    /**
     * liikutaan vaakatason suuntaan
     *
     * @param j
     * @param k
     */
    public static void verticalMovement(int j, int k) {
        try {
            if (Character.isLowerCase(board[r + j][c + k * 2].charAt(0)) || " ".equals(board[r + j][c + k * 2])) {
                oldPiece = board[r + j][c + k * 2];
                board[r][c] = " ";
                if (kingIsSafe()) {
                    list = list + r + c + (r + j) + (c + k * 2) + oldPiece;
                }
                board[r][c] = "K";
                board[r + j][c + k * 2] = oldPiece;
            }
        } catch (Exception e) {
        }
    }

    /**
     * liikutaan pystytason suuntaan
     *
     * @param j
     * @param k
     */
    public static void horizontalMovement(int j, int k) {
        try {
            if (Character.isLowerCase(board[r + j * 2][c + k].charAt(0)) || " ".equals(board[r + j * 2][c + k])) {
                oldPiece = board[r + j * 2][c + k];
                board[r][c] = " ";
                if (kingIsSafe()) {
                    list = list + r + c + (r + j * 2) + (c + k) + oldPiece;
                }
                board[r][c] = "K";
                board[r + j * 2][c + k] = oldPiece;
            }
        } catch (Exception e) {
        }
    }
}
