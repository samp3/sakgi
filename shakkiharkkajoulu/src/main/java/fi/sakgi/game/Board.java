package fi.sakgi.game;

import fi.sakgi.movealgorithms.Bishop;
import fi.sakgi.movealgorithms.King;
import fi.sakgi.movealgorithms.Knight;
import fi.sakgi.movealgorithms.Pawn;
import fi.sakgi.movealgorithms.Queen;
import fi.sakgi.movealgorithms.Rook;
import java.util.*;

/**
 * Shakkipöytä, pitää kirjaa kaikista mahdollisista siirroista
 * @author sampe
 */
public class Board {

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
     * toisinpäin.
     */
    public static void flip() {
        String str;
        for (int i = 0; i < 32; i++) {
            int row = i / 8;
            int column = i % 8;
            if (Character.isUpperCase(board[row][column].charAt(0))) {
                str = board[row][column].toLowerCase();
            } else {
                str = board[row][column].toUpperCase();
            }
            if (Character.isUpperCase(board[7 - row][7 - column].charAt(0))) {
                board[row][column] = board[7 - row][7 - column].toLowerCase();
            } else {
                board[row][column] = board[7 - row][7 - column].toUpperCase();
            }
            board[7 - row][7 - column] = str;
        }
        //Pitää myös vaihtaa kuninkaiden sijainnit toisinpäin
        int tempKing = kingPosC;
        kingPosC = 63 - kingPosL;
        kingPosL = 63 - tempKing;
    }

    /**
     * Tekee listan kaikista mahdollisista siirroista, käy yksitellen jokaisen
     * ruudun läpi ja hakee siellä sijaitsevalla nappulalle mahdolliset
     * siirrot(jos siellä sijaitsee jokin nappula).
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

    /**
     * Tarkastaa onko kuningas turvassa siirron jälkeen
     *
     * @return
     */
    public static boolean isKingSafe() {
        //bishop & queen
        int temp = 1;
        for (int i = -1; i <= 1; i += 2) {
            for (int j = -1; j <= 1; j += 2) {
                try {
                    while (" ".equals(board[kingPosC / 8 + temp * i][kingPosC % 8 + temp * j])) {
                        temp++;
                    }
                    if ("b".equals(board[kingPosC / 8 + temp * i][kingPosC % 8 + temp * j])
                            || "q".equals(board[kingPosC / 8 + temp * i][kingPosC % 8 + temp * j])) {
                        return false;
                    }
                } catch (Exception e) {
                }
                temp = 1;
            }
        }
        //rook & queen
        for (int i = -1; i <= 1; i += 2) {
            try {
                while (" ".equals(board[kingPosC / 8][kingPosC % 8 + temp * i])) {
                    temp++;
                }
                if ("r".equals(board[kingPosC / 8][kingPosC % 8 + temp * i])
                        || "q".equals(board[kingPosC / 8][kingPosC % 8 + temp * i])) {
                    return false;
                }
            } catch (Exception e) {
            }
            temp = 1;
            try {
                while (" ".equals(board[kingPosC / 8 + temp * i][kingPosC % 8])) {
                    temp++;
                }
                if ("r".equals(board[kingPosC / 8 + temp * i][kingPosC % 8])
                        || "q".equals(board[kingPosC / 8 + temp * i][kingPosC % 8])) {
                    return false;
                }
            } catch (Exception e) {
            }
            temp = 1;
        }
        //knight
        for (int i = -1; i <= 1; i += 2) {
            for (int j = -1; j <= 1; j += 2) {
                try {
                    if ("k".equals(board[kingPosC / 8 + i][kingPosC % 8 + j * 2])) {
                        return false;
                    }
                } catch (Exception e) {
                }
                try {
                    if ("k".equals(board[kingPosC / 8 + i * 2][kingPosC % 8 + j])) {
                        return false;
                    }
                } catch (Exception e) {
                }
            }
        }
        //pawn
        if (kingPosC >= 16) {
            try {
                if ("p".equals(board[kingPosC / 80 - 1][kingPosC % 8 - 1])) {
                    return false;
                }
            } catch (Exception e) {
            }
            try {
                if ("p".equals(board[kingPosC / 80 - 1][kingPosC % 8 + 1])) {
                    return false;
                }
            } catch (Exception e) {
            }
            //king
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i != 0 || j != 0) {
                        try {
                            if ("a".equals(board[kingPosC / 8 + i][kingPosC % 8 + j])) {
                                return false;
                            }
                        } catch (Exception e) {
                        }
                    }
                }
            }
        }
        return true;
    }
}
