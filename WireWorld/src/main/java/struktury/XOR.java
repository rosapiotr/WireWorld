package struktury;

import kontroler.NowyDialog;

public class XOR extends StartElement {

    public XOR(int[][] tab1) {
        super(tab1);
    }

    @Override
    public void insert(String text) {

        setXandY(text);

        if (error == 0) {                               //jesli podano poprawne współrzędne
            try {
                for (int column = 0; column < 22; column++) {
                    if (column < 5) {
                        tab1[y][x + column] = 3;
                        tab1[y + 2][x + column] = 3;
                    } else if (column == 5) {
                        tab1[y - 1][x + column] = 3;
                        tab1[y + 3][x + column] = 3;
                    } else if (column == 6) {
                        tab1[y - 2][x + column] = 3;
                        tab1[y + 4][x + column] = 3;
                    } else if (column == 7) {
                        tab1[y - 2][x + column] = 3;
                        tab1[y][x + column] = 3;
                        tab1[y + 1][x + column] = 3;
                        tab1[y + 2][x + column] = 3;
                        tab1[y + 4][x + column] = 3;
                    } else if (column == 8) {
                        tab1[y - 1][x + column] = 3;
                        tab1[y][x + column] = 3;
                        tab1[y + 2][x + column] = 3;
                        tab1[y + 3][x + column] = 3;
                    } else if (column == 9 || column == 10) {
                        tab1[y][x + column] = 3;
                        tab1[y + 1][x + column] = 3;
                        tab1[y + 2][x + column] = 3;
                    } else if (column > 10) {
                        tab1[y + 1][x + column] = 3;
                    }
                }
            } catch (IndexOutOfBoundsException e){             //w przypadku gdy wspolrzedne znajduja sie poza tablica
                NowyDialog.indexDialog();
            }
        }
    }
}
