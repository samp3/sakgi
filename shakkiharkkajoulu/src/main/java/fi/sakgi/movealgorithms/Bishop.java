package fi.sakgi.movealgorithms;

import static fi.sakgi.game.Board.board;
import static fi.sakgi.game.Board.isKingSafe;

public class Bishop {

    /**
     * luokka palauttaa indeksissä i sijaitsevan lähetin kaikki mahdolliset
     * siirrot. Kaikki luokat tässä packagessa tekevät saman jutun.
     *
     * @param i
     * @return
     */
    public static String legalBishopMoves(int i) {
        String list = "", oldPiece;
        int r = i / 8, c = i % 8;
        int temp = 1;
        for (int j = -1; j <= 1; j += 2) {
            for (int k = -1; k <= 1; k += 2) {
                try {
                    while (" ".equals(board[r + temp * j][c + temp * k])) {
                        oldPiece = board[r + temp * j][c + temp * k];
                        board[r][c] = " ";
                        board[r + temp * j][c + temp * k] = "B";
                        if (isKingSafe()) {
                            list = list + r + c + (r + temp * j) + (c + temp * k) + oldPiece;
                        }
                        board[r][c] = "B";
                        board[r + temp * j][c + temp * k] = oldPiece;
                        temp++;
                    }
                    if (Character.isLowerCase(board[r + temp * j][c + temp * k].charAt(0))) {
                        oldPiece = board[r + temp * j][c + temp * k];
                        board[r][c] = " ";
                        board[r + temp * j][c + temp * k] = "B";
                        if (isKingSafe()) {
                            list = list + r + c + (r + temp * j) + (c + temp * k) + oldPiece;
                        }
                        board[r][c] = "B";
                        board[r + temp * j][c + temp * k] = oldPiece;
                    }
                } catch (Exception e) {
                }
                temp = 1;
            }
        }
        return list;
    }
    
}
