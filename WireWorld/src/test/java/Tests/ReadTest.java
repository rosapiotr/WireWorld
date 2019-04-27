package Tests;

import main.Read;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReadTest {

    @Test
    public void testGetText() {
        String text = "ElectronHead: 15 17\nXOR: 11 12";
        Read read = new Read(text);
        String[] pola = read.getText();
        assertTrue(pola[0].equals("ElectronHead: 15 17"));
        assertTrue(pola[1].equals("XOR: 11 12"));
    }

    @Test
    public void testRead() {
        String text = "AND: 11 14";
        Read read = new Read(text);
        int[][] plansza = read.read();
        assertTrue(plansza[14][11] == 3);
        assertTrue(plansza[14][20] == 3);
        assertTrue(plansza[17][20] == 3);
        assertTrue(plansza[18][30] == 3);

        text = "Diode: 10 10 Reversed";
        read = new Read(text);
        plansza = read.read();
        assertTrue(plansza[10][10] == 3);
        assertTrue(plansza[10][23] == 3);
        assertTrue(plansza[10][16] == 0);
        assertTrue(plansza[11][17] == 3);

        text = "ElectronHead: 15 17";
        read = new Read(text);
        plansza = read.read();
        assertTrue(plansza[17][15] == 1);

        text = "ElectronTail: 15 15";
        read = new Read(text);
        plansza = read.read();
        assertTrue(plansza[15][15] == 2);

        text = "OR: 19 12";
        read = new Read(text);
        plansza = read.read();
        assertTrue(plansza[12][19] == 3);
        assertTrue(plansza[13][25] == 3);
        assertTrue(plansza[15][24] == 3);
        assertTrue(plansza[11][25] == 3);

        text = "Repeater: 13 13";
        read = new Read(text);
        plansza = read.read();
        assertTrue(plansza[13][13] == 3);
        assertTrue(plansza[13][22] == 3);
        assertTrue(plansza[12][21] == 3);

        text = "Wire: 11 15 ; 15 15";
        read = new Read(text);
        plansza = read.read();
        assertTrue(plansza[15][11] == 3);
        assertTrue(plansza[15][12] == 3);
        assertTrue(plansza[15][13] == 3);
        assertTrue(plansza[15][14] == 3);
        assertTrue(plansza[15][15] == 3);

        text = "XOR: 5 5";
        read = new Read(text);
        plansza = read.read();
        assertTrue(plansza[5][5] == 3);
        assertTrue(plansza[5][9] == 3);
        assertTrue(plansza[6][15] == 3);
        assertTrue(plansza[8][10] == 3);
    }
}