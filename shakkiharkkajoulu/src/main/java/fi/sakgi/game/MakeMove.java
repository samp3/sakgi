package fi.sakgi.game;

import fi.sakgi.game.Board;
import static fi.sakgi.game.Board.board;

/**
 * MakeMove tekee siirrot
 *
 * @author sampe
 */
public class MakeMove {
//lisää myös enpassant ja linnoitukseen

    /**
     * Tekee siirron
     *
     * @param move
     */
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
    //lisää undomove tekoälyä varten
}
