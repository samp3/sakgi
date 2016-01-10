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

/**
 * Lähtin liikkumisalgoritmin testausta (ja samalla queenin)
 *
 * @author sampe
 */
public class TestBishop {

    public TestBishop() {
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

    /**
     * lähetin liikkumisalgoritmin testausta
     */
    @Test
    public void testBishop() {
        for (int i = 0; i < 8; i++) {
            System.out.println(Arrays.toString(Board.board[i]));
        }
        MakeMove.makeMove("7242 ");
        System.out.println(Board.allLegalMoves());
        MakeMove.makeMove("1333 ");
        System.out.println(Board.allLegalMoves());
        MakeMove.makeMove("1535 ");
        System.out.println(Board.allLegalMoves());

        MakeMove.makeMove("4233p");
        System.out.println(Board.allLegalMoves());

        for (int i = 0; i < 8; i++) {
            System.out.println(Arrays.toString(Board.board[i]));
        }
    }
}
