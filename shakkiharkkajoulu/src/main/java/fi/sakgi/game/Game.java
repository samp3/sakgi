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

    public Game() {
        this.intrface = new ChessInterface();
        this.playerWhite = new Player();
        this.playerBlack = new Player();
        this.board = new Board();
        gameIsOver = false;
        whiteTurn = true;
    }

    //käynnistää pelin
    public void play() {
        this.intrface.setUp();
        
        String winner = "";
////        goThroughPiecesAndCheckIfKingIsAlive(winner);
//        if (winner.equals("k")) {
//            System.out.println("Black won");
//        } else {
//            System.out.println("White won");
//        }
    }

    public void changeTurn() {
        if (this.whiteTurn) {
            this.whiteTurn = false;
        } else {
            this.whiteTurn = true;
        }
    }

//    public void checkIfKingIsAlive() {
//        String str = "";
//        goThroughPiecesAndCheckIfKingIsAlive(str);
//        if (str.equals("kK") || str.equals("Kk")) {
//            gameIsOver = false;
//        } else {
//            gameIsOver = true;
//        }
//
//    }
//
//    public void goThroughPiecesAndCheckIfKingIsAlive(String str) {
//
//        for (int i = 0; i < 64; i++) {
//            switch (Board.board[i / 8][i % 8]) {
//                case "K":
//                    str += "K";
//                    break;
//                case "k":
//                    str += "k";
//                    break;
//            }
//        }
//
//    }

}
