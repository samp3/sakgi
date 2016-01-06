package fi.sakgi.chesspiece;

import static fi.sakgi.game.Board.board;
import static fi.sakgi.game.Board.isKingSafe;

public class Knight {

    public static String legalKnightMoves(int i) {
        String list = "", oldPiece;
        int r = i / 8, c = i % 8;
        for (int j = -1; j <= 1; j += 2) {
            for (int k = -1; k <= 1; k += 2) {
                try {
                    if (Character.isLowerCase(board[r + j][c + k * 2].charAt(0)) || " ".equals(board[r + j][c + k * 2])) {
                        oldPiece = board[r + j][c + k * 2];
                        board[r][c] = " ";
                        if (isKingSafe()) {
                            list = list + r + c + (r + j) + (c + k * 2) + oldPiece;
                        }
                        board[r][c] = "K";
                        board[r + j][c + k * 2] = oldPiece;
                    }
                } catch (Exception e) {
                }
                try {
                    if (Character.isLowerCase(board[r + j * 2][c + k].charAt(0)) || " ".equals(board[r + j * 2][c + k])) {
                        oldPiece = board[r + j * 2][c + k];
                        board[r][c] = " ";
                        if (isKingSafe()) {
                            list = list + r + c + (r + j * 2) + (c + k) + oldPiece;
                        }
                        board[r][c] = "K";
                        board[r + j * 2][c + k] = oldPiece;
                    }
                } catch (Exception e) {
                }
            }
        }
        return list;
    }
}
