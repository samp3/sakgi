package fi.sakgi.chesspiece;

/**
 * Luokka Kuninkaalle.
 */
import fi.sakgi.game.Move;
public class KingPiece extends ChessPiece {

    public KingPiece(PieceColor color) {
        super(color);
        this.type = PieceType.KING;
    }

    @Override
    public void legalMove(Move m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
