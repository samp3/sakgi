package fi.sakgi.chessinterface;

import fi.sakgi.game.Board;
import java.awt.Graphics;
import java.util.function.Consumer;

/**
 * Tämä raja-pinta mahdollistaa pelin porttaamisen esimerkiksi androidille
 * myöhemmin.
 */
public interface GraphicalChessBoard {

/**
 * Päivittää pöydän
 * @param g 
 */
    public void refresh(Graphics g);

}
