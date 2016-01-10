package fi.sakgi.movealgorithms;

import fi.sakgi.game.Board;
import java.util.Arrays;
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
    /**
     * kaikki sallitut siirrot alotuspositiosta
     */
    @Test
    public void getAllLegalMoves() {
        for (int i = 0; i < 8; i++) {
            System.out.println(Arrays.toString(Board.board[i]));
        }
        System.out.println(board.allLegalMoves());
        assertEquals("","");
    }
}
