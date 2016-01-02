package fi.sakgi.chessinterface;

import Game.Board;
import Game.Move;
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
 * Tämä luokka hoitaa pelin grafiikan, sekä hiiren liikkuutelut ja nappuloiden siirrot(fyysisesti)
 */

public class ChessInterface extends JPanel implements GraphicalChessBoard, MouseListener, MouseMotionListener {

    private int startX;
    private int startY;
    private int endX;
    private int endY;

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
     * Tähän kerään kaikki, mitä pöydälle tarvitsee piirtää. Piirrot ovat jaettu seuraavasti: drawPieces(pelinappuloiden piirto),
     * paintBoard(värittää pöydän mustat ja valkoiset ruudut) sekä drawCoord(piirtää koordinaatit pöydälle).
     * @param g 
     */

    public void paintComponent(Graphics g) {
        paintBoard(g);
        drawCoords(g);
        drawPieces(g);

    }

    public void drawPieces(Graphics g) {
        Image chessPiecesImage = new ImageIcon("rsz_chesspieces.png").getImage();
        //kuinka iso block on ja kuinka iso yksi kuva on SIZExSIZE
        int sizeOfOneImage = 50;
        drawPawns(chessPiecesImage, g, sizeOfOneImage);
        drawKings(chessPiecesImage, g, sizeOfOneImage);
        drawQueens(chessPiecesImage, g, sizeOfOneImage);
        drawRooks(chessPiecesImage, g, sizeOfOneImage);
        drawBishops(chessPiecesImage, g, sizeOfOneImage);
        drawKnights(chessPiecesImage, g, sizeOfOneImage);

    }

    public void drawPawns(Image img, Graphics g, int size) {
        int j = 2;
        for (int i = 0; i < 8; i++) {
            //valkoiset
            g.drawImage(img, j * size, 8 * size, (j + 1) * size, 9 * size, size * 5, 0, size * 6, size, this);
            //mustat
            g.drawImage(img, j * size, 3 * size, (j + 1) * size, 4 * size, size * 5, size, size * 6, size * 2, this);
            j++;
        }
    }

    public void drawKings(Image img, Graphics g, int size) {
        //valkoinen kuningas
        g.drawImage(img, 6 * size, 9 * size, 7 * size, 10 * size, 0, 0, size, size, this);
        //musta kuningas
        g.drawImage(img, 6 * size, 2 * size, 7 * size, 3 * size, 0, size, size, size * 2, this);
    }

    public void drawQueens(Image img, Graphics g, int size) {

        //valkoinen kuningatar
        g.drawImage(img, 5 * size, 9 * size, 6 * size, 10 * size, size, 0, size * 2, size, this);
        //musta kuningatar
        g.drawImage(img, 5 * size, 2 * size, 6 * size, 3 * size, size, size, size * 2, size * 2, this);

    }

    public void drawRooks(Image img, Graphics g, int size) {
        //valkoiset tornit
        g.drawImage(img, 2 * size, 9 * size, 3 * size, 10 * size, size * 2, 0, size * 3, size, this);
        g.drawImage(img, 9 * size, 9 * size, 10 * size, 10 * size, size * 2, 0, size * 3, size, this);
        //mustat tornit
        g.drawImage(img, 2 * size, 2 * size, 3 * size, 3 * size, size * 2, size, size * 3, size * 2, this);
        g.drawImage(img, 9 * size, 2 * size, 10 * size, 3 * size, size * 2, size, size * 3, size * 2, this);
    }

    public void drawBishops(Image img, Graphics g, int size) {
        //valkoiset lähetit
        g.drawImage(img, 4 * size, 9 * size, 5 * size, 10 * size, size * 3, 0, size * 4, size, this);
        g.drawImage(img, 7 * size, 9 * size, 8 * size, 10 * size, size * 3, 0, size * 4, size, this);
        //mustat lähetit
        g.drawImage(img, 4 * size, 2 * size, 5 * size, 3 * size, size * 3, size, size * 4, size * 2, this);
        g.drawImage(img, 7 * size, 2 * size, 8 * size, 3 * size, size * 3, size, size * 4, size * 2, this);
    }

    public void drawKnights(Image img, Graphics g, int size) {
        //valkoiset hepat
        g.drawImage(img, 3 * size, 9 * size, 4 * size, 10 * size, size * 4, 0, size * 5, size, this);
        g.drawImage(img, 8 * size, 9 * size, 9 * size, 10 * size, size * 4, 0, size * 5, size, this);
        //mustat hevoset
        g.drawImage(img, 3 * size, 2 * size, 4 * size, 3 * size, size * 4, size, size * 5, size * 2, this);
        g.drawImage(img, 8 * size, 2 * size, 9 * size, 3 * size, size * 4, size, size * 5, size * 2, this);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addMoveListener(Consumer<Move> listener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        startX = e.getX();
        startY = e.getY();
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.endX = e.getX();
        this.endY = e.getY();
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

}
