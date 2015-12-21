package main;

public class Game {

    private Player playerWhite;
    private Player playerBlack;
    private Block[][] board;

    public Game() {
        board = new Block[8][8];
    }

    public void play() {
        createBoard();
    }

    public void createBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                //joka toinen mustaa , valkoista
                Block block = new Block(i, j);
                board[i][j] = block;

            }
        }
    }

    public Block[][] getBoard() {

        return this.board;
    }

}
