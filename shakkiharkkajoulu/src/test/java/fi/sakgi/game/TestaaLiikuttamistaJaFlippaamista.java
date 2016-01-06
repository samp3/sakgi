/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.sakgi.game;

import fi.sakgi.game.Board;
import fi.sakgi.game.Move;
import static fi.sakgi.game.Move.makeMove;
import java.util.Arrays;
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
public class TestaaLiikuttamistaJaFlippaamista {

    public TestaaLiikuttamistaJaFlippaamista() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }
    Board board;
    Move movemaker;

    @Before
    public void setUp() {

        board = new Board();
        for (int i = 0; i < 8; i++) {
            System.out.println(Arrays.toString(board.board[i]));
        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void MovePawn60To50AndFlipBoard() {
        System.out.println(board.allLegalMoves());
        makeMove("6050 ");
        for (int i = 0; i < 8; i++) {
            System.out.println(Arrays.toString(board.board[i]));
        }
        System.out.println("FLIPATAAN PÖYTÄ");
        board.flip();
        for (int i = 0; i < 8; i++) {
            System.out.println(Arrays.toString(board.board[i]));
        }
    }
}
