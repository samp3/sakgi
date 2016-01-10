package fi.sakgi.chessinterface;

import fi.sakgi.game.Board;
import static fi.sakgi.game.MakeMove.makeMove;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.event.*;
import javax.swing.ImageIcon;

/**
 * Tama luokka hoitaa pelin grafiikan, seka hiiren liikkuutelut ja
 * nappuloiden siirrot(fyysisesti)
 */
public class ChessInterface extends JPanel implements GraphicalChessBoard, MouseListener, MouseMotionListener {
/**
 * startX ja Y pitavat tallella nappulan lahtokoordinaatteja, endX ja Y taas, minne nappula halutaan siirtaa.
 * sizeOfSquare kertoo kuinka iso yksi ruutu on ja nappulan koon myoskin.
 */
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private final int sizeOfSquare = 50;
    //valkoisen vuorolla vuoro = true
    private boolean vuoro = true;
    private JFrame f;
    /**
     * Tekee kaiken, mitä JFramelle tarvii tehda, ennenkuin voi alkaa piirtelemaan.
     */
    public void setUp() {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        f = new JFrame("Chess");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600, 600);
        f.getContentPane().add(this);
        f.setLocationRelativeTo(null);
        f.setBackground(Color.DARK_GRAY);
        f.setVisible(true);

    }

    /**
     * Tahan kerataan kaikki, mita poydalle tarvitee piirtaa. Piirrot ovat
     * jaettu seuraavasti: paintBoard(varittaa mustat ja valkoiset ruudut),
     * refresh(), joka pÃ¤ivittÃ¤Ã¤ nappuloiden paikat seka drawCoords, joka
     * piirtaa koordinaatit. Kummankin varin vuorolle on omat metodinsa.
     *
     * @param g
     */
    public void paintComponent(Graphics g) {
//jos valkoisen vuoro niin piirtää seuraavalla tavalla:
        if (vuoro) {
            g.setColor(Color.DARK_GRAY);
            g.fillRect(0, 0, 600, 600);

            paintBoard(g);
            refresh(g);
            drawCoords(g);
//mustan vuoro:
        } else {
            g.setColor(Color.DARK_GRAY);
            g.fillRect(0, 0, 600, 600);

            paintBoard(g);
            refresh(g);
            drawCoordsW(g);

        }
    }

    /**
     * Paivittaa nappuloiden sijainnin pöydällä.
     *
     * @param g
     */
    @Override
    public void refresh(Graphics g) {
        Image chessPiecesImage = new ImageIcon("rsz_chesspieces.png").getImage();
        /*
         valkoisen vuoro
         */
        if (vuoro) {
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
            /**
             * mustan vuoro
             */
        } else {
            for (int i = 0; i < 64; i++) {
                int j = -1;
                int k = -1;
                switch (Board.board[i / 8][i % 8]) {

                    case "p":
                        j = 5;
                        k = 0;

                        break;
                    case "r":
                        j = 2;
                        k = 0;

                        break;
                    case "k":
                        j = 4;
                        k = 0;

                        break;
                    case "b":
                        j = 3;
                        k = 0;

                        break;
                    case "q":
                        j = 1;
                        k = 0;

                        break;
                    case "a":
                        j = 0;
                        k = 0;

                        break;
                    case "A":
                        j = 0;
                        k = 1;

                        break;
                    case "P":
                        j = 5;
                        k = 1;

                        break;
                    case "R":
                        j = 2;
                        k = 1;

                        break;
                    case "K":
                        j = 4;
                        k = 1;

                        break;
                    case "B":
                        j = 3;
                        k = 1;

                        break;
                    case "Q":
                        j = 1;
                        k = 1;
                        break;
                }
                if (k != -1 && j != -1) {
                    g.drawImage(chessPiecesImage, 100 + (i % 8) * this.sizeOfSquare, 100 + (i / 8) * this.sizeOfSquare, (i % 8 + 1) * this.sizeOfSquare + 100, 100 + (i / 8 + 1) * this.sizeOfSquare, j * 50, k * 50, (j + 1) * 50, (k + 1) * 50, this);
                }
            }
        }

    }

    /**
     * Piirtaa shakkipoydan
     *
     * @param g
     */
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

    /**
     * piirtaa koordinaatit poydalle valkoisen vuorolla
     *
     * @param g
     */
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

    /**
     * Piirtää käänteiset koordinaatit mustan vuorolla
     *
     * @param g
     */
    public void drawCoordsW(Graphics g) {

        g.setColor(Color.WHITE);
        char[] charArray = {'s', 'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A'};
        int j = 1;
        int raja = 125 + 7 * 50;
        for (int i = 125; i <= raja; i += 50) {

            g.drawString("" + charArray[j], i, 92);
            g.drawString("" + charArray[j], i, 515);
            g.drawString("" + j, 85, i);
            g.drawString("" + j, 510, i);
            j++;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    /**
     * Ottaa hiirenpainalluksesta alkukoordinaatit
     *
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e) {
        //testataan ensin osuuko hiirenpainallus pelilaudalle.
        if (e.getX() < 8 * this.sizeOfSquare + 100 && e.getX() > 100 && e.getY() < 8 * this.sizeOfSquare + 100 && e.getY() > 100) {
            //tallenetaan lahto-koordinaatit
            startX = e.getX();
            startY = e.getY();
            repaint();

        }
    }

    /**
     * Ottaa loppukoordinaatit(kun hiirenpainallukseta päästetään irti). Tekee
     * myös siirron
     *
     * @param e
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        //testataan ensin osuuko hiirenpainallus pelilaudalle.
        if (e.getX() < 8 * this.sizeOfSquare + 100 && e.getX() > 100 && e.getY() < 8 * this.sizeOfSquare + 100 && e.getY() > 100) {
            //tallenetaan koordinaatit ylos 
            endX = e.getX();
            endY = e.getY();

            //tarkastetaan, etta paastetty nappain on mouse1
            if (e.getButton() == MouseEvent.BUTTON1) {
                String move = "";
                if ((startY - 100) / sizeOfSquare == 1 && (endY - 100) / sizeOfSquare == 0 && Board.board[(startY - 100) / sizeOfSquare][(startX - 100) / sizeOfSquare].equals("P")) {
                    //sotilas paasee takarack. Tee kysymys, miksi halutaan promotea. Laitetaan aluksi Q

                    move = "" + (startX - 100) / sizeOfSquare + (endX - 100) / sizeOfSquare + Board.board[(endY - 100) / sizeOfSquare][(endX - 100) / sizeOfSquare] + "QP";
                } else {
                    move = "" + (startY - 100) / sizeOfSquare + (startX - 100) / sizeOfSquare + (endY - 100) / sizeOfSquare + (endX - 100) / sizeOfSquare + Board.board[(endY - 100) / sizeOfSquare][(endX - 100) / sizeOfSquare];
                }
                String legalMoves = Board.allLegalMoves();
                if (legalMoves.replaceAll(move, "").length() < legalMoves.length()) {
                    makeMove(move);
                    if (vuoro) {
                        vuoro = false;
                    } else {
                        vuoro = true;
                    }
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
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
