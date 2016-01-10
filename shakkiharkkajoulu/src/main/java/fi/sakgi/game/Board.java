package fi.sakgi.game;

import fi.sakgi.movealgorithms.Bishop;
import fi.sakgi.movealgorithms.King;
import fi.sakgi.movealgorithms.Knight;
import fi.sakgi.movealgorithms.Pawn;
import fi.sakgi.movealgorithms.Queen;
import fi.sakgi.movealgorithms.Rook;

/**
 * Shakkipöytä, pitää kirjaa kaikista mahdollisista siirroista
 *
 * @author sampe
 */
public class Board {

    /**
     * pelilauta, isot kirjaimet vastaavat niitä kenen vuoro on
     */
    public static String[][] board = {
        {"r", "k", "b", "q", "a", "b", "k", "r"},
        {"p", "p", "p", "p", "p", "p", "p", "p"},
        {" ", " ", " ", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", " ", " ", " "},
        {" ", " ", " ", " ", " ", " ", " ", " "},
        {"P", "P", "P", "P", "P", "P", "P", "P"},
        {"R", "K", "B", "Q", "A", "B", "K", "R"}};
    //kingPosC ja kingPosL pitävät kuninkaiden sijainnit tallessa, jotta voidaan testata tekeekö siirto oman kuninkaan uhatuksi
    public static int kingPosC, kingPosL;

    /**
     * Kaikki siirtologiikka on UPPERCASE näkökulmasta, joten vuoron vaihtuessa
     * pitää kääntää pelilauta SEKÄ swäpätä kaikki lowercaset uppercaseksi ja
     * toisinpäin. Myös pitää vaihtaa kuninkaat
     */
    public static void flip() {
        String temp;
        for (int i = 0; i < 32; i++) {
            int r = i / 8, c = i % 8;
            if (Character.isUpperCase(board[r][c].charAt(0))) {
                temp = board[r][c].toLowerCase();
            } else {
                temp = board[r][c].toUpperCase();
            }
            if (Character.isUpperCase(board[7 - r][7 - c].charAt(0))) {
                board[r][c] = board[7 - r][7 - c].toLowerCase();
            } else {
                board[r][c] = board[7 - r][7 - c].toUpperCase();
            }
            board[7 - r][7 - c] = temp;
        }
        int kingTemp = kingPosC;
        kingPosC = 63 - kingPosL;
        kingPosL = 63 - kingTemp;

    }

    /**
     * Tekee listan(String muodossa) kaikista mahdollisista siirroista, käy
     * yksitellen jokaisen ruudun läpi ja hakee siellä sijaitsevalla nappulalle
     * mahdolliset siirrot(jos siellä sijaitsee jokin nappula).
     *
     *
     * @return
     */
    public static String allLegalMoves() {
        String list = "";
        for (int i = 0; i < 64; i++) {
            switch (board[i / 8][i % 8]) {
                case "P":
                    list += Pawn.legalPawnMoves(i);
                    break;
                case "R":
                    list += Rook.legalRookMoves(i);
                    break;
                case "K":
                    list += Knight.legalKnightMoves(i);
                    break;
                case "B":
                    list += Bishop.legalBishopMoves(i);
                    break;
                case "Q":
                    list += Queen.legalQueenMoves(i);
                    break;
                case "A":
                    list += King.legalKingMoves(i);
                    break;
            }
        }
        return list;
    }

}
