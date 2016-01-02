/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.sakgi.chesspiece;

import fi.sakgi.game.Move;

/**
 *Luokka kuningattarelle
 */
public class QueenPiece extends ChessPiece {

    

    public QueenPiece(PieceColor color) {
        super(color);
        this.type = PieceType.QUEEN;
        
    }

    @Override
    public void legalMove(Move m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
