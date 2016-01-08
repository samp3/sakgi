package fi.sakgi.movealgorithms;

import static fi.sakgi.game.Board.board;
import static fi.sakgi.game.Board.isKingSafe;
import static fi.sakgi.game.Board.kingPosC;

public class King {

    public static String legalKingMoves(int i) {
        String list = "", oldPiece;
        int r = i / 8, c = i % 8;
        for (int j = 0; j < 9; j++) {
            if (j != 4) {
                try {
                    if (Character.isLowerCase(board[r - 1 + j / 3][c - 1 + j % 3].charAt(0)) || " ".equals(board[r - 1 + j / 3][c - 1 + j % 3])) {
                        oldPiece = board[r - 1 + j / 3][c - 1 + j % 3];
                        board[r][c] = " ";
                        board[r - 1 + j / 3][c - 1 + j % 3] = "A";
                        int kingTemp = kingPosC;
                        kingPosC = i + (j / 3) * 8 + j % 3 - 9;
                        if (isKingSafe()) {
                            list = list + r + c + (r - 1 + j / 3) + (c - 1 + j % 3) + oldPiece;
                        }
                        board[r][c] = "A";
                        board[r - 1 + j / 3][c - 1 + j % 3] = oldPiece;
                        kingPosC = kingTemp;
                    }
                } catch (Exception e) {
                }
            }
        }
        return list;
    }
}
