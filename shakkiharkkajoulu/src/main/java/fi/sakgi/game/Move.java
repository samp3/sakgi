package fi.sakgi.game;

import static fi.sakgi.game.Board.board;

public class Move {
//lisää myös enpassant ja linnoitukseen

    public static void makeMove(String move) {
        if (move.charAt(4) != 'P') {
            board[Character.getNumericValue(move.charAt(2))][Character.getNumericValue(move.charAt(3))] = board[Character.getNumericValue(move.charAt(0))][Character.getNumericValue(move.charAt(1))];
            board[Character.getNumericValue(move.charAt(0))][Character.getNumericValue(move.charAt(1))] = " ";
            if ("A".equals(board[Character.getNumericValue(move.charAt(2))][Character.getNumericValue(move.charAt(3))])) {
                Board.kingPosC = 8 * Character.getNumericValue(move.charAt(2)) + Character.getNumericValue(move.charAt(3));
            }
        } else {
            //vika kirjain P, eli siirto on pawnpromotion
            board[1][Character.getNumericValue(move.charAt(0))] = " ";
            board[0][Character.getNumericValue(move.charAt(1))] = String.valueOf(move.charAt(3));
        }

    }

    public static void undoMove(String move) {
        if (move.charAt(4) != 'P') {
            board[Character.getNumericValue(move.charAt(0))][Character.getNumericValue(move.charAt(1))] = board[Character.getNumericValue(move.charAt(2))][Character.getNumericValue(move.charAt(3))];
            board[Character.getNumericValue(move.charAt(2))][Character.getNumericValue(move.charAt(3))] = String.valueOf(move.charAt(4));
            if ("A".equals(board[Character.getNumericValue(move.charAt(0))][Character.getNumericValue(move.charAt(1))])) {
                Board.kingPosC = 8 * Character.getNumericValue(move.charAt(0)) + Character.getNumericValue(move.charAt(1));

            }
        } else {
            //if pawn promotion
            board[1][Character.getNumericValue(move.charAt(0))] = "P";
            board[0][Character.getNumericValue(move.charAt(1))] = String.valueOf(move.charAt(2));
        }
    }
}
