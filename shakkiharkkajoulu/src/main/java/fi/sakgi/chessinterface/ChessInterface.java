package fi.sakgi.chessinterface;

import fi.sakgi.game.Board;
import fi.sakgi.game.Move;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.function.Consumer;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * TÃ¤mÃ¤ luokka hoitaa pelin grafiikan, sekÃ¤ hiiren liikkuutelut ja nappuloiden
 * siirrot(fyysisesti)
 */
public class ChessInterface extends JPanel implements GraphicalChessBoard, MouseListener, MouseMotionListener {

    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private final int sizeOfSquare = 50;
    private Board board;

    public void setUp() {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        JFrame f = new JFrame("Chess");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600, 600);
        f.getContentPane().add(this);
        f.setLocationRelativeTo(null);
        f.setBackground(Color.DARK_GRAY);
        f.setVisible(true);

    }

    /**
     * TÃ¤hÃ¤n kerÃ¤Ã¤n kaikki, mitÃ¤ pÃ¶ydÃ¤lle tarvitsee piirtÃ¤Ã¤. Piirrot ovat jaettu
     * seuraavasti: paintBoard(vÃ¤rittÃ¤Ã¤pÃ¶ydÃ¤n mustat ja valkoiset ruudut) sekÃ¤
     * refresh(), joka pÃ¤ivittÃ¤Ã¤ nappuloiden paikat.
     *
     * @param g
     */
    public void paintComponent(Graphics g) {

        paintBoard(g);
        drawCoords(g);
        refresh(g);

    }

    @Override
    public void refresh(Graphics g) {
        Image chessPiecesImage = new ImageIcon("rsz_chesspieces.png").getImage();
        for (int i = 0; i < 64; i++) {
            int j = -1;
            int k = -1;
            switch (Board.board[i / 8][i % 8]) {

                case "P":
                    j = 5;
                    k = 0;

                    break;
                case "R":
                    j = 2;
                    k = 0;

                    break;
                case "K":
                    j = 4;
                    k = 0;

                    break;
                case "B":
                    j = 3;
                    k = 0;

                    break;
                case "Q":
                    j = 1;
                    k = 0;

                    break;
                case "A":
                    j = 0;
                    k = 0;

                    break;
                case "a":
                    j = 0;
                    k = 1;

                    break;
                case "p":
                    j = 5;
                    k = 1;

                    break;
                case "r":
                    j = 2;
                    k = 1;

                    break;
                case "k":
                    j = 4;
                    k = 1;

                    break;
                case "b":
                    j = 3;
                    k = 1;

                    break;
                case "q":
                    j = 1;
                    k = 1;

                    break;

            }
            if (k != -1 && j != -1) {
                g.drawImage(chessPiecesImage, 100 + (i % 8) * this.sizeOfSquare, 100 + (i / 8) * this.sizeOfSquare, (i % 8 + 1) * this.sizeOfSquare + 100, 100 + (i / 8 + 1) * this.sizeOfSquare, j * 50, k * 50, (j + 1) * 50, (k + 1) * 50, this);
            }
        }

    }

    public void paintBoard(Graphics g) {
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(100, 100, 400, 400);
        for (int i = 100; i <= 400; i += 100) {
            for (int j = 100; j <= 400; j += 100) {
                g.clearRect(i, j, 50, 50);
            }
        }
        for (int i = 150; i <= 450; i += 100) {
            for (int j = 150; j <= 450; j += 100) {
                g.clearRect(i, j, 50, 50);
            }
        }

    }

    public void drawCoords(Graphics g) {
        g.setColor(Color.WHITE);
        char[] charArray = {'s', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        int j = 1;
        int k = 8;
        int raja = 125 + 7 * 50;
        for (int i = 125; i <= raja; i += 50) {

            g.drawString("" + charArray[j], i, 92);
            g.drawString("" + charArray[j], i, 515);
            g.drawString("" + k, 85, i);
            g.drawString("" + k, 510, i);
            j++;
            k--;
        }

    }

    @Override
    public void setBoard(Board board) {
        this.board = board;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //testataan ensin osuuko hiirenpainallus pelilaudalle.
        if (e.getX() < 8 * this.sizeOfSquare + 100 && e.getX() > 100 && e.getY() < 8 * this.sizeOfSquare + 100 && e.getY() > 100) {
            //tallenetaan koordinaatit ylÃ¶s 
            startX = e.getX();
            startY = e.getY();
            repaint();

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //testataan ensin osuuko hiirenpainallus pelilaudalle.
        if (e.getX() < 8 * this.sizeOfSquare + 100 && e.getX() > 100 && e.getY() < 8 * this.sizeOfSquare + 100 && e.getY() > 100) {
            //tallenetaan koordinaatit ylÃ¶s 
            endX = e.getX();
            endY = e.getY();

            //tarkastetaan, ettÃ¤ pÃ¤Ã¤stetty nÃ¤ppÃ¤in on mouse1
            if (e.getButton() == MouseEvent.BUTTON1) {
                String move = "";
                if (startY / sizeOfSquare == 3 && endY / sizeOfSquare == 2 && Board.board[startY - 100 / sizeOfSquare][startX - 100 / sizeOfSquare].equals("P")) {
                    //sotilas pÃ¤Ã¤see takarack. Tee kysymys, miksi halutaan promotea. Laitetaan aluksi Q
                    move = "" + (startX - 100) / sizeOfSquare + (endX - 100) / sizeOfSquare + Board.board[(endY - 100) / sizeOfSquare][(endX - 100) / sizeOfSquare] + "QP";
                } else {
                    move = "" + (startY - 100) / sizeOfSquare + (startX - 100) / sizeOfSquare + (endY - 100) / sizeOfSquare + (endX - 100) / sizeOfSquare + Board.board[(endY - 100) / sizeOfSquare][(endX - 100) / sizeOfSquare];
                }
                String legalMoves = Board.allLegalMoves();
                if (legalMoves.replaceAll(move, "").length() < legalMoves.length()) {
                    Move.makeMove(move);
                    Board.flip();
                }
            }

            repaint();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
//        //testataan ensin osuuko hiirenpainallus pelilaudalle.
//        if (e.getX() < 8 * this.sizeOfSquare + 100 && e.getX() > 100 && e.getY() < 8 * this.sizeOfSquare + 100 && e.getY() > 100) {
//            //tallenetaan koordinaatit ylÃ¶s 
//            endX = e.getX();
//            endY = e.getY();
//
//            //tarkastetaan, ettÃ¤ pÃ¤Ã¤stetty nÃ¤ppÃ¤in on mouse1
//            if (e.getButton() == MouseEvent.BUTTON1) {
//                String move = "";
//                if (startY / sizeOfSquare == 3 && endY / sizeOfSquare == 2 && Board.board[startY - 100 / sizeOfSquare][startX - 100 / sizeOfSquare].equals("P")) {
//                    //sotilas pÃ¤Ã¤see takarack. Tee kysymys, miksi halutaan promotea. Laitetaan aluksi Q
//                    move = "" + (startX - 100) / sizeOfSquare + (endX - 100) / sizeOfSquare + Board.board[(endY - 100) / sizeOfSquare][(endX - 100) / sizeOfSquare] + "QP";
//                } else {
//                    move = "" + (startY - 100) / sizeOfSquare + (startX - 100) / sizeOfSquare + (endY - 100) / sizeOfSquare + (endX - 100) / sizeOfSquare + Board.board[(endY - 100) / sizeOfSquare][(endX - 100) / sizeOfSquare];
//                }
//                String legalMoves = Board.allLegalMoves();
//                if (legalMoves.replaceAll(move, "").length() < legalMoves.length()) {
//                    Move.makeMove(move);
//                }
//            }
//
//            repaint();

//        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

}