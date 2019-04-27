package struktury;

import kontroler.NowyDialog;

public class ElectronTail extends StartElement {

    public ElectronTail(int[][] tab1) {
        super(tab1);
    }

    @Override
    public void insert(String text) {

        setXandY(text);
        if (error == 0) {                       //jesli podano poprawne współrzędne
            try {
                tab1[y][x] = 2;
            } catch (IndexOutOfBoundsException e) {             //w przypadku gdy wspolrzedne znajduja sie poza tablica
                NowyDialog.indexDialog();
            }
        }
    }
}
