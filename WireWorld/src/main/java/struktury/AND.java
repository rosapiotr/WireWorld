package struktury;

import kontroler.NowyDialog;

public class AND extends StartElement {

    public AND(int[][] tab1) {
        super(tab1);
    }

    @Override
    public void insert(String text) {

        setXandY(text);

        if (error == 0) {                               //jesli podano poprawne współrzędne
            try {
                for (int column = 0; column < 22; column++) {
                    if (column < 5 || column == 8 || column == 10) {
                        tab1[y][x + column] = 3;
                        tab1[y + 3][x + column] = 3;
                    } else if (column == 5 || column == 7) {
                        tab1[y][x + column] = 3;
                        tab1[y + 4][x + column] = 3;
                        tab1[y + 5][x + column] = 3;
                        tab1[y + 6][x + column] = 3;
                    } else if (column == 6) {
                        tab1[y][x + column] = 3;
                        tab1[y + 7][x + column] = 3;
                    } else if (column == 9) {
                        tab1[y][x + column] = 3;
                        tab1[y + 2][x + column] = 3;
                        tab1[y + 3][x + column] = 3;
                        tab1[y + 4][x + column] = 3;
                    } else if (column == 11) {
                        tab1[y][x + column] = 3;
                        tab1[y + 2][x + column] = 3;
                        tab1[y + 4][x + column] = 3;
                    } else if (column == 12 || column == 14) {
                        tab1[y + 1][x + column] = 3;
                        tab1[y + 5][x + column] = 3;
                    } else if (column == 13) {
                        tab1[y + 1][x + column] = 3;
                        tab1[y + 4][x + column] = 3;
                        tab1[y + 5][x + column] = 3;
                        tab1[y + 6][x + column] = 3;
                    } else if (column == 15) {
                        tab1[y + 2][x + column] = 3;
                        tab1[y + 3][x + column] = 3;
                        tab1[y + 4][x + column] = 3;
                        tab1[y + 6][x + column] = 3;
                    } else if (column == 16) {
                        tab1[y + 6][x + column] = 3;
                    } else if (column == 17) {
                        tab1[y + 5][x + column] = 3;
                    } else if (column > 17) {
                        tab1[y + 4][x + column] = 3;
                    }
                }
            } catch (IndexOutOfBoundsException e) {             //w przypadku gdy wspolrzedne znajduja sie poza tablica
                NowyDialog.indexDialog();
            }
        }

    }
}
