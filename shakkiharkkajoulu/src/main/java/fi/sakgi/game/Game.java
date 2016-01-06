package fi.sakgi.game;

import fi.sakgi.chessinterface.ChessInterface;
import java.util.LinkedList;

/**
 * Tämä on pääluokka, jossa ohjelman eri osaset yhdistyvät kokonaisuudeksi.
 */

public class Game {
    
    private Player playerWhite;
    private Player playerBlack;
    private Board board;
    private boolean gameIsOver;
    private boolean whiteTurn;
    private ChessInterface intrface;
    private Move move;
    
    public Game() {
        this.intrface = new ChessInterface();
        this.playerWhite = new Player();
        this.playerBlack = new Player();
        this.board = new Board();
        gameIsOver = false;
        whiteTurn = true;
        this.move = new Move();
        
        
    }
    
    public void play() {
        this.intrface.setUp();
        
        gameLoop();
        
    }
    
    public void gameLoop() {
        
    }
    
    public void changeTurn() {
        if (this.whiteTurn) {
            this.whiteTurn = false;
        } else {
            this.whiteTurn = true;
        }
    }
    
}
