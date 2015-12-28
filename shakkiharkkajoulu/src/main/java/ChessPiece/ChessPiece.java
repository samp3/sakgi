package ChessPiece;

import Game.Move;

public abstract class ChessPiece {

    PieceColor color;
    PieceType type;

    public ChessPiece(PieceColor color) {
        this.color = color;
    }

    public PieceType getPieceType() {
        return this.type;
    }

    public PieceColor getPieceColor() {
        return this.color;
    }

    public abstract void legalMove(Move m);
}
