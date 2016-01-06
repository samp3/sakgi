package fi.sakgi.chessinterface;

import fi.sakgi.game.Board;
import java.awt.Graphics;
import java.util.function.Consumer;

/**
 * Tämä raja-pinta mahdollistaa pelin porttaamisen esimerkiksi androidille
 * myöhemmin.
 */
public interface GraphicalChessBoard {

    public void setBoard(Board board);

    public void refresh(Graphics g);

}
