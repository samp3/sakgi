
package Game;

import ChessPiece.BishopPiece;
import ChessPiece.KingPiece;
import ChessPiece.KnightPiece;
import ChessPiece.PawnPiece;
import ChessPiece.PieceColor;
import ChessPiece.PieceType;
import ChessPiece.QueenPiece;
import ChessPiece.RookPiece;
/*
 *Shakkipelin lauta, lauta koostuu 64 ruudusta (Block).
 */

public class Board {

    private Block[][] board;

    public Board() {
        board = new Block[8][8];

    }

    /**
     * Asettaa pöydälle Blockit
     */
    public void createBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                //joka toinen mustaa , valkoista
                Block block = new Block(i, j);
                block.setPieceNull();
                board[i][j] = block;

            }
        }
    }
    
    /**
     * Asettaa pelinappulat blockeille alkuasentoon.
     */
    public void setPiecesOnBoard() {
        setPawnsOnBoard();
        board[0][0].setPieceOnBlock(new RookPiece(PieceColor.BLACK));
        board[0][7].setPieceOnBlock(new RookPiece(PieceColor.BLACK));
        board[7][0].setPieceOnBlock(new RookPiece(PieceColor.WHITE));
        board[7][7].setPieceOnBlock(new RookPiece(PieceColor.WHITE));
        board[0][1].setPieceOnBlock(new KnightPiece(PieceColor.BLACK));
        board[0][6].setPieceOnBlock(new KnightPiece(PieceColor.BLACK));
        board[7][1].setPieceOnBlock(new KnightPiece(PieceColor.WHITE));
        board[7][6].setPieceOnBlock(new KnightPiece(PieceColor.WHITE));
        board[0][2].setPieceOnBlock(new BishopPiece(PieceColor.BLACK));
        board[0][5].setPieceOnBlock(new BishopPiece(PieceColor.BLACK));
        board[7][2].setPieceOnBlock(new BishopPiece(PieceColor.WHITE));
        board[7][5].setPieceOnBlock(new BishopPiece(PieceColor.WHITE));
        board[0][3].setPieceOnBlock(new QueenPiece(PieceColor.BLACK));
        board[7][3].setPieceOnBlock(new QueenPiece(PieceColor.WHITE));
        board[0][4].setPieceOnBlock(new KingPiece(PieceColor.BLACK));
        board[7][4].setPieceOnBlock(new KingPiece(PieceColor.WHITE));

    }

    public void setPawnsOnBoard() {
        for (int i = 0; i < 8; i++) {
            board[6][i].setPieceOnBlock(new PawnPiece(PieceColor.WHITE));
            board[1][i].setPieceOnBlock(new PawnPiece(PieceColor.BLACK));
        }
    }
    public Block[][] getBoard() {
        return this.board;
    }
    
    public Block getBlock(int x, int y) {
        return this.board[x][y];
    }
}
