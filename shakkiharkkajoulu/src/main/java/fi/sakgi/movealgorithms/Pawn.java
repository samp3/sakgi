package fi.sakgi.movealgorithms;

import static fi.sakgi.game.Board.board;
import static fi.sakgi.movealgorithms.KingSafety.kingIsSafe;

/**
 * Sotilaan liikumisalgoritmi
 *
 * @author sampe
 */
public class Pawn {

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
     * Metodi palauttaa laudalla sijaitsevan sotilaan kaikki mahdolliset
     * siirrot. Parametri i kertoo metodille, missä nappula sijaitsee.
     *
     * @param i
     * @return
     */
    public static String legalPawnMoves(int i) {

        r = i / 8;
        c = i % 8;

        eatAndPromote(i);
        moveOneSquare(i);
        promoteNoCapture(i);
        moveTwoSquares(i);

        return list;
    }

    /**
     * Syöminen ja syöminen + promote
     *
     * @param i
     */
    public static void eatAndPromote(int i) {
        for (int j = -1; j <= 1; j += 2) {
            //syö
            try {
                if (Character.isLowerCase(board[r - 1][c + j].charAt(0)) && i >= 16) {
                    oldPiece = board[r - 1][c + j];
                    board[r][c] = " ";
                    board[r - 1][c + j] = "P";
                    if (kingIsSafe()) {
                        list = list + r + c + (r - 1) + (c + j) + oldPiece;
                    }
                    board[r][c] = "P";
                    board[r - 1][c + j] = oldPiece;
                }
            } catch (Exception e) {
            }
            //syö ja promote
            try {
                if (Character.isLowerCase(board[r - 1][c + j].charAt(0)) && i < 16) {
                    String[] temp = {"Q", "R", "B", "K"};
                    for (int k = 0; k < 4; k++) {
                        oldPiece = board[r - 1][c + j];
                        board[r][c] = " ";
                        board[r - 1][c + j] = temp[k];
                        if (kingIsSafe()) {
                            list = list + c + (c + j) + oldPiece + temp[k] + "P";
                        }
                        board[r][c] = "P";
                        board[r - 1][c + j] = oldPiece;
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    /**
     * Pawn liikkuu yhden squaren
     *
     * @param i
     */
    public static void moveOneSquare(int i) {
        try {
            if (" ".equals(board[r - 1][c]) && i >= 16) {
                oldPiece = board[r - 1][c];
                board[r][c] = " ";
                board[r - 1][c] = "P";
                if (KingSafety.kingIsSafe()) {
                    list = list + r + c + (r - 1) + c + oldPiece;
                }
                board[r][c] = "P";
                board[r - 1][c] = oldPiece;
            }
        } catch (Exception e) {
        }
    }

    /**
     * Pawn promote ilman, että syö nappulaa
     *
     * @param i
     */
    public static void promoteNoCapture(int i) {
        try {
            if (" ".equals(board[r - 1][c]) && i < 16) {
                String[] temp = {"Q", "R", "B", "K"};
                for (int k = 0; k < 4; k++) {
                    oldPiece = board[r - 1][c];
                    board[r][c] = " ";
                    board[r - 1][c] = temp[k];
                    if (kingIsSafe()) {

                        list = list + c + c + oldPiece + temp[k] + "P";
                    }
                    board[r][c] = "P";
                    board[r - 1][c] = oldPiece;
                }
            }
        } catch (Exception e) {
        }
    }

    /**
     * Pawn liikkuu 2 ruutua
     *
     * @param i
     */
    public static void moveTwoSquares(int i) {
        try {
            if (" ".equals(board[r - 1][c]) && " ".equals(board[r - 2][c]) && i >= 48) {
                oldPiece = board[r - 2][c];
                board[r][c] = " ";
                board[r - 2][c] = "P";
                if (kingIsSafe()) {
                    list = list + r + c + (r - 2) + c + oldPiece;
                }
                board[r][c] = "P";
                board[r - 2][c] = oldPiece;
            }
        } catch (Exception e) {
        }
    }
}
