package Game;

import java.util.LinkedList;

public class Game {
    //lista siirtoja

    private Player playerWhite;
    private Player playerBlack;
    private Board board;
    //Joka vuorolla käydään läpi jokainen pöydällä oleva block. Tsekataan onko blockilla nappulaa, jos on, otetaan ylös
    //kaikki nappulan mahdolliset siirrot ja lisätään ne moves LinkedListiin. Nyt voimme tarkastaa sisältyykö pelaajan antama siirto (actionlistenerin kautta)
    //hyväksyttyihin siirtoihin (jotka ovat moves listalla).
    private LinkedList<Move> moves;
    private boolean gameIsOver;
    private boolean whiteTurn;
    private MouseListener listen;

    public Game() {
        this.playerWhite = new Player();
        this.playerBlack = new Player();
        this.board = new Board();
        moves = new LinkedList<>();
        gameIsOver = false;
        whiteTurn = true;
        this.listen = new MouseListener();

    }

    public void play() {
        board.createBoard();
        board.setPiecesOnBoard();
        gameLoop();

    }

    public void gameLoop() {
        while (!gameIsOver) {
            //mouseListener ottaa alku- ja loppukoordinaatit, sekä Piece:n mitä halutaan liikuttaa. 
            //Asetan aluksi moven nulliksi. Tee uusi metodi/luokka actionlistenerille.
            //Move tehdään vasta askIfMoveIsValid metodissa Player luokassa, koska haluamme loopata Pelaajan antamia
            //syötteitä
            Move move = null;
            if (whiteTurn) {
                this.playerWhite.askIfMoveIsValid(move);
            } else {

                this.playerBlack.askIfMoveIsValid(move);
            }
            changeTurn();
        }
    }

    

    public Block[][] getBoard() {

        return this.board.getBoard();
    }

    public void changeTurn() {
        if (this.whiteTurn) {
            this.whiteTurn = false;
        } else {
            this.whiteTurn = true;
        }
    }

}