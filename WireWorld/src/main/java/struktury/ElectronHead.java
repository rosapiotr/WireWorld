package struktury;

import kontroler.NowyDialog;

public class ElectronHead extends StartElement {

    public ElectronHead(int[][] tab1) {
        super(tab1);
    }

    @Override
    public void insert(String text) {

        setXandY(text);
        if (error == 0) {                         //jesli podano poprawne współrzędne
            try {
                tab1[y][x] = 1;
            } catch (IndexOutOfBoundsException e) {             //w przypadku gdy wspolrzedne znajduja sie poza tablica
                NowyDialog.indexDialog();
            }
        }
    }
}
