package fi.sakgi.movealgorithms;

import fi.sakgi.game.Board;
import fi.sakgi.game.MakeMove;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestKing {

    public TestKing() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testKing() {
        for (int i = 0; i < 8; i++) {
            System.out.println(Arrays.toString(Board.board[i]));
        }
        MakeMove.makeMove("7434 ");
        System.out.println(Board.allLegalMoves());
        MakeMove.makeMove("1333 ");
        System.out.println(Board.allLegalMoves());
        MakeMove.makeMove("1535 ");
        System.out.println(Board.allLegalMoves());
        for (int i = 0; i < 8; i++) {
            System.out.println(Arrays.toString(Board.board[i]));
        }
        MakeMove.makeMove("3433p");
        System.out.println(Board.allLegalMoves());

        for (int i = 0; i < 8; i++) {
            System.out.println(Arrays.toString(Board.board[i]));
        }
    }
}
