package fi.sakgi.movealgorithms;

import static fi.sakgi.game.Board.board;
import static fi.sakgi.game.Board.isKingSafe;

public class Rook {

    public static String legalRookMoves(int i) {
        String list = "", oldPiece;
        int r = i / 8, c = i % 8;
        int temp = 1;
        for (int j = -1; j <= 1; j += 2) {
            try {
                while (" ".equals(board[r][c + temp * j])) {
                    oldPiece = board[r][c + temp * j];
                    board[r][c] = " ";
                    board[r][c + temp * j] = "R";
                    if (isKingSafe()) {
                        list = list + r + c + r + (c + temp * j) + oldPiece;
                    }
                    board[r][c] = "R";
                    board[r][c + temp * j] = oldPiece;
                    temp++;
                }
                if (Character.isLowerCase(board[r][c + temp * j].charAt(0))) {
                    oldPiece = board[r][c + temp * j];
                    board[r][c] = " ";
                    board[r][c + temp * j] = "R";
                    if (isKingSafe()) {
                        list = list + r + c + r + (c + temp * j) + oldPiece;
                    }
                    board[r][c] = "R";
                    board[r][c + temp * j] = oldPiece;
                }
            } catch (Exception e) {
            }
            temp = 1;
            try {
                while (" ".equals(board[r + temp * j][c])) {
                    oldPiece = board[r + temp * j][c];
                    board[r][c] = " ";
                    board[r + temp * j][c] = "R";
                    if (isKingSafe()) {
                        list = list + r + c + (r + temp * j) + c + oldPiece;
                    }
                    board[r][c] = "R";
                    board[r + temp * j][c] = oldPiece;
                    temp++;
                }
                if (Character.isLowerCase(board[r + temp * j][c].charAt(0))) {
                    oldPiece = board[r + temp * j][c];
                    board[r][c] = " ";
                    board[r + temp * j][c] = "R";
                    if (isKingSafe()) {
                        list = list + r + c + (r + temp * j) + c + oldPiece;
                    }
                    board[r][c] = "R";
                    board[r + temp * j][c] = oldPiece;
                }
            } catch (Exception e) {
            }
            temp = 1;
        }
        return list;
    }
}
