package Tests;

import javafx.scene.layout.GridPane;
import main.Logic;
import org.junit.Test;

import static org.junit.Assert.*;

public class LogicTest {

    @Test
    public void testChange() {
        int[][] plansza = new int[50][50];
        plansza[10][10] = 2;
        plansza[10][11] = 1;
        plansza[10][12] = 3;
        plansza[10][13] = 3;
        Logic logic = new Logic(new GridPane());
        logic.change(plansza);
        assertTrue(plansza[10][10] == 3);
        assertTrue(plansza[10][11] == 2);
        assertTrue(plansza[10][12] == 1);
        assertTrue(plansza[10][13] == 3);
        assertTrue(plansza[11][11] == 0);
    }
}