package fi.sakgi.chesspiece;

import static fi.sakgi.game.Board.board;
import static fi.sakgi.game.Board.isKingSafe;

public class Pawn {

    public static String legalPawnMoves(int i) {
        String list = "", oldPiece;
        int r = i / 8, c = i % 8;
        for (int j = -1; j <= 1; j += 2) {
            //syö
            try {
                if (Character.isLowerCase(board[r - 1][c + j].charAt(0)) && i >= 16) {
                    oldPiece = board[r - 1][c + j];
                    board[r][c] = " ";
                    board[r - 1][c + j] = "P";
                    if (isKingSafe()) {
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
                        if (isKingSafe()) {
                            //column1,column2,captured-piece,new-piece,P
                            list = list + c + (c + j) + oldPiece + temp[k] + "P";
                        }
                        board[r][c] = "P";
                        board[r - 1][c + j] = oldPiece;
                    }
                }
            } catch (Exception e) {
            }
        }
        //siirry yksi ruutu
        try {
            if (" ".equals(board[r - 1][c]) && i >= 16) {
                oldPiece = board[r - 1][c];
                board[r][c] = " ";
                board[r - 1][c] = "P";
                if (isKingSafe()) {
                    list = list + r + c + (r - 1) + c + oldPiece;
                }
                board[r][c] = "P";
                board[r - 1][c] = oldPiece;
            }
        } catch (Exception e) {
        }
        //promotion no capture
        try {
            if (" ".equals(board[r - 1][c]) && i < 16) {
                String[] temp = {"Q", "R", "B", "K"};
                for (int k = 0; k < 4; k++) {
                    oldPiece = board[r - 1][c];
                    board[r][c] = " ";
                    board[r - 1][c] = temp[k];
                    if (isKingSafe()) {

                        list = list + c + c + oldPiece + temp[k] + "P";
                    }
                    board[r][c] = "P";
                    board[r - 1][c] = oldPiece;
                }
            }
        } catch (Exception e) {
        }
        //kaksi ruutua kerrallaan
        try {
            if (" ".equals(board[r - 1][c]) && " ".equals(board[r - 2][c]) && i >= 48) {
                oldPiece = board[r - 2][c];
                board[r][c] = " ";
                board[r - 2][c] = "P";
                if (isKingSafe()) {
                    list = list + r + c + (r - 2) + c + oldPiece;
                }
                board[r][c] = "P";
                board[r - 2][c] = oldPiece;
            }
        } catch (Exception e) {
        }
        return list;
    }
}
