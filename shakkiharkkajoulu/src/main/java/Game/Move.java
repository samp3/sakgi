package Game;

import ChessPiece.PieceType;

/**
 * Move oliot ovat nappuloiden siirtoja pöydällä.
 */

public class Move {

    private Block start;
    private Block end;
    private PieceType piece;

    public Move(PieceType piece, Block start, Block end) {
        this.start = start;
        this.end = end;
        this.piece = piece;
    }

}
