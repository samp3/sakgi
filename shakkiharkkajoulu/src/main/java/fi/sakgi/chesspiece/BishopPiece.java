/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessPiece;

import Game.Move;

/**
 *Luokka lähetille
 */
public class BishopPiece extends ChessPiece {

    
    

    public BishopPiece(PieceColor color) {
        super(color);
        this.type = PieceType.BISHOP;
        
    }

    @Override
    public void legalMove(Move m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
