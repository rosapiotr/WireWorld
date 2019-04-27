package struktury;

import kontroler.NowyDialog;

public class Repeater extends StartElement {

    public Repeater(int[][] tab1) {
        super(tab1);
    }

    @Override
    public void insert(String text) {

        setXandY(text);
        if (error == 0) {                               //jesli podano poprawne współrzędne
            try {
                for (int column = 0; column < 10; column++) {
                    if (column == 0 || column == 9) {
                        tab1[y][x + column] = 3;
                    } else if (column > 0 && column < 9) {
                        tab1[y - 1][x + column] = 3;
                        tab1[y + 1][x + column] = 3;
                    }
                }
            } catch (IndexOutOfBoundsException e) {             //w przypadku gdy wspolrzedne znajduja sie poza tablica
                NowyDialog.indexDialog();
            }
        }
    }
}
