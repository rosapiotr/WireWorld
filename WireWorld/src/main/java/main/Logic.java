package main;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Logic {

    private GridPane root;


    public Logic(GridPane root) {
        this.root = root;
    }

    public void paint(int[][] tab) {
    	
        for (int row = 0; row < tab.length; row++) {
            for (int column = 0; column < tab[0].length; column++) {

                Pane pane1 = new Pane();
                pane1.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));

                Pane pane2 = new Pane();
                pane2.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));

                Pane pane3 = new Pane();
                pane3.setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));

                if (tab[row][column] == 1)
                    root.add(pane1, column, row);

                else if (tab[row][column] == 2)
                    root.add(pane2, column, row);

                else if (tab[row][column] == 3)
                    root.add(pane3, column, row);
            }
        }
    }

    public void change(int[][] tab) {

        int[][] tempTab = new int[tab.length][tab[0].length]; // tymczasowa, potrzebna do zmiany
        int heads; // liczenie głów

        for (int row = 0; row < 50; row++) {
            for (int column = 0; column < 50; column++) {
                heads = 0;

                if (tab[row][column] == 0)
                    tempTab[row][column] = 0;

                else if (tab[row][column] == 1)
                    tempTab[row][column] = 2;

                else if (tab[row][column] == 2)
                    tempTab[row][column] = 3;

                else {
                    if (row > 0 && column > 0 && tab[row - 1][column - 1] == 1)
                        heads++;

                    if (column > 0 && tab[row][column - 1] == 1)
                        heads++;

                    if (row < 49 && column > 0 && tab[row + 1][column - 1] == 1)
                        heads++;

                    if (row > 0 && tab[row - 1][column] == 1)
                        heads++;

                    if (row < 49 && tab[row + 1][column] == 1)
                        heads++;

                    if (row > 0 && column < 49 && tab[row - 1][column + 1] == 1)
                        heads++;

                    if (column < 49 && tab[row][column + 1] == 1)
                        heads++;

                    if (row < 49 && column < 49 && tab[row + 1][column + 1] == 1)
                        heads++;

                    if (heads == 1 || heads == 2)
                        tempTab[row][column] = 1;
                    else
                        tempTab[row][column] = 3;
                }
            }
        }

        for (int row = 0; row < 50; row++) {
                System.arraycopy(tempTab, 0, tab, 0, tempTab.length);
        }
    }

    public void clear() {
        root.getChildren().clear();
    }
}
