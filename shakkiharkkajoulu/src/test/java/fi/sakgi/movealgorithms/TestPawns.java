
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
 *Testaa sotilaan liikkumista.
 * @author sampe
 */
public class TestPawns {

    public TestPawns() {
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
     * Testaa kaikki mahdolliset pawn liikkeet
     */
    @Test
    public void testPawnMoves() {
        for (int i = 0; i < 8; i++) {
            System.out.println(Arrays.toString(Board.board[i]));
        }
        MakeMove.makeMove("6044 ");
        System.out.println(Board.allLegalMoves());
        MakeMove.makeMove("1333 ");
        System.out.println(Board.allLegalMoves());
        MakeMove.makeMove("1535 ");
        System.out.println(Board.allLegalMoves());
        MakeMove.makeMove("0556 ");
        System.out.println(Board.allLegalMoves());
        MakeMove.makeMove("6115 ");
        System.out.println(Board.allLegalMoves());
        
        MakeMove.makeMove("4433p");
        System.out.println(Board.allLegalMoves());
        MakeMove.makeMove("54aQP");
        System.out.println(Board.allLegalMoves());
        MakeMove.makeMove("6215 ");
        System.out.println(Board.allLegalMoves());
        MakeMove.makeMove("55 QP"); 
        System.out.println(Board.allLegalMoves());
        for (int i = 0; i < 8; i++) {
            System.out.println(Arrays.toString(Board.board[i]));
        }
    }
}
