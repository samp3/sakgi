package Game;

import ChessPiece.ChessPiece;
import ChessPiece.PieceType;
/**
*Shakkilaudan ruudut, laudalla on 64 blockia (ruutua). ChessPiece:t sijaitsevat ruuduilla.
*/

public class Block {

    private int x;
    private int y;
    private ChessPiece piece;

    public Block(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setPieceOnBlock(ChessPiece piece) {
        this.piece = piece;
    }

    public void setPieceNull() {
        this.piece = null;
    }
    public ChessPiece getChessPiece() {
        return this.piece;
    }
}
