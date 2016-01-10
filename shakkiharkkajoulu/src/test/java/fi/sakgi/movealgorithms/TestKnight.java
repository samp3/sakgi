/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * Lähetin liikkeen testaamista
 *
 * @author sampe
 */
public class TestKnight {

    public TestKnight() {
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
     * Testaa lähtin liikettä
     */
    @Test
    public void TestKnight() {
        for (int i = 0; i < 8; i++) {
            System.out.println(Arrays.toString(Board.board[i]));
        }
        MakeMove.makeMove("7152 ");
        System.out.println(Board.allLegalMoves());
        MakeMove.makeMove("1334 ");
        System.out.println(Board.allLegalMoves());
        MakeMove.makeMove("1535 ");
        System.out.println(Board.allLegalMoves());
        for (int i = 0; i < 8; i++) {
            System.out.println(Arrays.toString(Board.board[i]));
        }
        MakeMove.makeMove("5234p");
        System.out.println(Board.allLegalMoves());

        for (int i = 0; i < 8; i++) {
            System.out.println(Arrays.toString(Board.board[i]));
        }
    }
}
