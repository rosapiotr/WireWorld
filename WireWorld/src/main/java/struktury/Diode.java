package struktury;

import kontroler.NowyDialog;

public class Diode extends Element {

    public Diode(int[][] tab1) {
        super(tab1);
    }

    @Override
    public void insert(String text) {

        int i = text.indexOf(' ');
        int k = text.indexOf(' ', i + 1);
        try {
            x = Integer.parseInt(text.substring(0, i));
            y = Integer.parseInt(text.substring(i + 1, k));
        } catch (NumberFormatException | StringIndexOutOfBoundsException e ) {
            NowyDialog.diodeDialog();
            error = 1;                              //flaga, ze podano bledne wspolrzedne
        }
        if (text.contains("Normal") && error == 0) {    //jesli podano poprawne współrzędne i Normal
            try {
                for (int column = 0; column < 14; column++) {      // z tylu elementów składa się dioda
                    if (column < 6 || column > 7) {
                        tab1[y][x + column] = 3;
                    } else if (column == 6) {
                        tab1[y - 1][x + column] = 3;
                        tab1[y][x + column] = 3;
                        tab1[y + 1][x + column] = 3;
                    } else if (column == 7) {
                        tab1[y - 1][x + column] = 3;
                        tab1[y + 1][x + column] = 3;
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                NowyDialog.numberDialog();
            }
        } else if (text.contains("Reversed") && error == 0) {   //jesli podano poprawne współrzędne i Reversed
            try {
                for (int column = 0; column < 14; column++) {
                    if (column < 6 || column > 7) {
                        tab1[y][x + column] = 3;
                    } else if (column == 6) {
                        tab1[y - 1][x + column] = 3;
                        tab1[y + 1][x + column] = 3;
                    } else if (column == 7) {
                        tab1[y - 1][x + column] = 3;
                        tab1[y][x + column] = 3;
                        tab1[y + 1][x + column] = 3;
                    }
                }
            } catch (IndexOutOfBoundsException e) {             //w przypadku gdy wspolrzedne znajduja sie poza tablica
                NowyDialog.numberDialog();
            }
        }
    }
}
