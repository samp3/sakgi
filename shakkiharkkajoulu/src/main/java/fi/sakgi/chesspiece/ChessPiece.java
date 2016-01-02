package fi.sakgi.chesspiece;
/**
 * ChessPiece:t sijaitsevat Blockeilla (ruuduilla). Ne eivät itse tiedä missä sijaitsevat.
 */

import fi.sakgi.game.Move;
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
    /**
     * Kertoo onko siirto sallittu
     * @param m 
     */
    public abstract void legalMove(Move m);
}
