package fi.sakgi.game;

import fi.sakgi.chessinterface.ChessInterface;
import static fi.sakgi.game.Board.board;
import static fi.sakgi.game.Board.kingPosC;
import static fi.sakgi.game.Board.kingPosL;
/**
 * Täältä käynnistetään peli
 */
public class Game {

    private final ChessInterface intrface;

    public Game() {
        this.intrface = new ChessInterface();
    }

    /**
     * käynnistää pelin
     */
    public void play() {
        while (!"A".equals(board[kingPosC / 8][kingPosC % 8])) {
            kingPosC++;
        }
        while (!"a".equals(board[kingPosL / 8][kingPosL % 8])) {
            kingPosL++;
        }
        intrface.setUp();

    }

}
