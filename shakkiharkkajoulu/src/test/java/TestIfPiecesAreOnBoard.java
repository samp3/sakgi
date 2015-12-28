/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ChessPiece.PieceColor;
import ChessPiece.PieceType;
import Game.Block;
import Game.Board;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sampe
 */
public class TestIfPiecesAreOnBoard {

    public TestIfPiecesAreOnBoard() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }
    private Board board;

    @Before
    public void setUp() {
        this.board = new Board();
        board.createBoard();
        board.setPiecesOnBoard();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void isIn00BlackRook() {
        Block block = this.board.getBlock(0, 0);

        assertEquals(block.getChessPiece().getPieceColor(), PieceColor.BLACK);
        assertEquals(block.getChessPiece().getPieceType(), PieceType.ROOK);

    }

    @Test
    public void isIn01BlackKnight() {
        Block block = this.board.getBlock(0, 1);

        assertEquals(block.getChessPiece().getPieceColor(), PieceColor.BLACK);
        assertEquals(block.getChessPiece().getPieceType(), PieceType.KNIGHT);

    }

    @Test
    public void isIn02BlackBishop() {
        Block block = this.board.getBlock(0, 2);

        assertEquals(block.getChessPiece().getPieceColor(), PieceColor.BLACK);
        assertEquals(block.getChessPiece().getPieceType(), PieceType.BISHOP);

    }

    @Test
    public void isIn03BlackQueen() {
        Block block = this.board.getBlock(0, 3);

        assertEquals(block.getChessPiece().getPieceColor(), PieceColor.BLACK);
        assertEquals(block.getChessPiece().getPieceType(), PieceType.QUEEN);

    }

    @Test
    public void isIn04BlackKing() {
        Block block = this.board.getBlock(0, 4);

        assertEquals(block.getChessPiece().getPieceColor(), PieceColor.BLACK);
        assertEquals(block.getChessPiece().getPieceType(), PieceType.KING);

    }
    @Test
    public void isIn77WhiteRook() {
        Block block = this.board.getBlock(7, 7);

        assertEquals(block.getChessPiece().getPieceColor(), PieceColor.WHITE);
        assertEquals(block.getChessPiece().getPieceType(), PieceType.ROOK);

    }
    @Test
    public void isIn67WhitePawn() {
        Block block = this.board.getBlock(6, 7);

        assertEquals(block.getChessPiece().getPieceColor(), PieceColor.WHITE);
        assertEquals(block.getChessPiece().getPieceType(), PieceType.PAWN);

    }
    @Test
    public void isIn10BlackPawn() {
        Block block = this.board.getBlock(1, 0);

        assertEquals(block.getChessPiece().getPieceColor(), PieceColor.BLACK);
        assertEquals(block.getChessPiece().getPieceType(), PieceType.PAWN);

    }

}
