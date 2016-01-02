
package fi.sakgi.chessinterface;

import Game.Board;
import Game.Move;
import java.util.function.Consumer;

/**
 * Tämä raja-pinta mahdollistaa pelin porttaamisen esimerkiksi androidille myöhemmin.
 */

public interface GraphicalChessBoard {
    public void setBoard(Board board);
    public void refresh();
    public void addMoveListener(Consumer<Move> listener);
}
