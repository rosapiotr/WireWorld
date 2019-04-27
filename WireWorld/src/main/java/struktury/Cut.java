package struktury;

import kontroler.NowyDialog;

public class Cut extends StartEndElement {

    public Cut(int[][] tab1) {
        super(tab1);
    }

    @Override
    public void insert(String text) {

        setCoordinates(text);

        if (error == 0) {                           //jesli podano poprawne współrzędne
            try {
                if (y == yEnd) {                    //jesli wstawiamy poziomo
                    if (xEnd > x) {                                             //jesli uzytkownik podal wiekszy xEnd niz x
                        for (int column = 0; column < xEnd - x + 1; column++) {
                            tab1[y][x + column] = 0;
                        }
                    } else {
                        for (int column = 0; column < x - xEnd + 1; column++) {
                            tab1[y][x - column] = 0;
                        }
                    }
                } else if (x == xEnd) {             //jesli wstawiamy pionowo
                    if (yEnd > y) {                                             //jesli uzytkownik podal wiekszy yEnd niz y
                        for (int column = 0; column < yEnd - y + 1; column++) {
                            tab1[y + column][x] = 0;
                        }
                    } else {
                        for (int column = 0; column < y - yEnd + 1; column++) {
                            tab1[y - column][x] = 0;
                        }
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                NowyDialog.indexDialog();
            }
        }
    }
}
