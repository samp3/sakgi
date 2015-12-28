
//import Game.Block;
//import Game.Game;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//public class TestaaKaksiulotteinenBlockTaulukko {
//
//    private Game game;
//
//    public TestaaKaksiulotteinenBlockTaulukko() {
//    }
//
//    @BeforeClass
//    public static void setUpClass() {
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//    }
//
//    @Before
//    public void setUp() {
//        game = new Game();
//        game.play();
//    }
//
//    @After
//    public void tearDown() {
//    }
//
//    @Test
//    public void isFirstNotNull() {
//
//        Block block = game.getBoard()[0][0];
//
//        assertNotNull("onko paikassa[0][0] olemassa block", block);
//    }
//
//    @Test
//    public void isLastNotNull() {
//
//        Block block = game.getBoard()[8][8];
//
//        assertNotNull("onko paikassa[8][8] olemassa block", block);
//    }
//
//    @Test
//    public void is66NotNull() {
//
//        Block block = game.getBoard()[6][6];
//
//        assertNotNull("onko paikassa[6][6] olemassa block", block);
//    }
//
//    @Test
//    public void doesPointToDifferentObjects1() {
//        Block block1 = game.getBoard()[0][0];
//        Block block2 = game.getBoard()[8][8];
//        assertNotSame("Osoittaako samaan olioon?", block1, block2);
//
//    }
//
//    @Test
//    public void doesPointToDifferentObjects2() {
//        Block block1 = game.getBoard()[1][1];
//        Block block2 = game.getBoard()[2][2];
//        assertNotSame("Osoittaako samaan olioon?", block1, block2);
//
//    }
//
//    @Test
//    public void doesPointToDifferentObjects3() {
//        Block block1 = game.getBoard()[0][1];
//        Block block2 = game.getBoard()[0][2];
//        assertNotSame("Osoittaako samaan olioon?", block1, block2);
//
//    }
//
//    @Test
//    public void testBlockCoordinatesXaxis() {
//
//        Block block1 = game.getBoard()[8][8];
//        int x = block1.getX();
//        assertEquals("onko oikeat xkoordinaatit", 8, x);
//    }
//
//    @Test
//    public void testBlockCoordinatesYaxis() {
//
//        Block block1 = game.getBoard()[8][8];
//        int y = block1.getY();
//        assertEquals("onko oikeat xkoordinaatit", 8, y);
//    }
//
//    @Test
//    public void testBlockCoordinatesYaxis00() {
//
//        Block block1 = game.getBoard()[0][0];
//        int y = block1.getY();
//        assertEquals("onko oikeat xkoordinaatit", 0, y);
//    }
//
//    @Test
//    public void testBlockCoordinatesXaxis00() {
//
//        Block block1 = game.getBoard()[0][0];
//        int x = block1.getX();
//        assertEquals("onko oikeat xkoordinaatit", 0, x);
//    }
//
//}
