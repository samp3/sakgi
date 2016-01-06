package fi.sakgi.chesspiece;

import fi.sakgi.game.Board;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestLegalMovesStartPos {

    public TestLegalMovesStartPos() {
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
        board = new Board();

    }

    @After
    public void tearDown() {
    }

    @Test
    public void getAllLegalMoves() {
        System.out.println(board.allLegalMoves());
        assertEquals("","");
    }
}
