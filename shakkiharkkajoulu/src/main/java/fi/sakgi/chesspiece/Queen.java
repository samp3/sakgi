package fi.sakgi.chesspiece;

import static fi.sakgi.game.Board.board;
import static fi.sakgi.game.Board.isKingSafe;

public class Queen {

    public static String legalQueenMoves(int i) {
        String list = "", oldPiece;
        int r = i / 8, c = i % 8;
        int temp = 1;
        for (int j = -1; j <= 1; j++) {
            for (int k = -1; k <= 1; k++) {
                if (j != 0 || k != 0) {
                    try {
                        while (" ".equals(board[r + temp * j][c + temp * k])) {
                            oldPiece = board[r + temp * j][c + temp * k];
                            board[r][c] = " ";
                            board[r + temp * j][c + temp * k] = "Q";
                            if (isKingSafe()) {
                                list = list + r + c + (r + temp * j) + (c + temp * k) + oldPiece;
                            }
                            board[r][c] = "Q";
                            board[r + temp * j][c + temp * k] = oldPiece;
                            temp++;
                        }
                        if (Character.isLowerCase(board[r + temp * j][c + temp * k].charAt(0))) {
                            oldPiece = board[r + temp * j][c + temp * k];
                            board[r][c] = " ";
                            board[r + temp * j][c + temp * k] = "Q";
                            if (isKingSafe()) {
                                list = list + r + c + (r + temp * j) + (c + temp * k) + oldPiece;
                            }
                            board[r][c] = "Q";
                            board[r + temp * j][c + temp * k] = oldPiece;
                        }
                    } catch (Exception e) {
                    }
                    temp = 1;
                }
            }
        }
        return list;
    }
}
