/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.sakgi.chesspiece;

import fi.sakgi.chesspiece.ChessPiece;
import fi.sakgi.chesspiece.KnightPiece;
import fi.sakgi.chesspiece.PawnPiece;
import fi.sakgi.chesspiece.PieceColor;
import fi.sakgi.chesspiece.PieceType;
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
public class TestaaToimiikoEnumit {

    public TestaaToimiikoEnumit() {
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
     * Testataan kahta eri PieceTypen ja PieceColorin omaavaa luokkaa, luokat
     * ovat siinä mielessä identisiä, että tämän pitäisi kattaa kaikki
     * ChessPiecen perivät luokat.
     */
    @Test
    public void TestIfKnightWorks() {
        ChessPiece heppa = new KnightPiece(PieceColor.WHITE);

        assertEquals(heppa.getPieceType(), PieceType.KNIGHT);
        assertEquals(heppa.getPieceColor(), PieceColor.WHITE);
    }

    @Test
    public void TestIfPawnWorks() {
        ChessPiece solttu = new PawnPiece(PieceColor.BLACK);

        assertEquals(solttu.getPieceType(), PieceType.PAWN);
        assertEquals(solttu.getPieceColor(), PieceColor.BLACK);
    }
}
