/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.sakgi.chesspiece;
import fi.sakgi.game.Move;

/**
 *Luokka tornille
 */
public class RookPiece extends ChessPiece {

    public RookPiece(PieceColor color) {
        super(color);
        this.type = PieceType.ROOK;

    }

    @Override
    public void legalMove(Move m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
