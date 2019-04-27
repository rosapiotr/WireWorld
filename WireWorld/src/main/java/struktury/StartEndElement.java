package struktury;

import kontroler.NowyDialog;

public abstract class StartEndElement extends Element {
    int xEnd = 0;
    int yEnd = 0;

    public StartEndElement(int[][] tab1) {
        super(tab1);
    }

    void setCoordinates(String text) {

        int i = text.indexOf(' ');
        int s = text.indexOf(';');
        int k = text.indexOf(' ', s + 2);

        try {
            this.x = Integer.parseInt(text.substring(0, i));
            this.y = Integer.parseInt(text.substring(i + 1, s - 1));
            this.xEnd = Integer.parseInt(text.substring(s + 2, k));
            this.yEnd = Integer.parseInt(text.substring(k + 1));
        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {       //w przypadku gdy wspolrzedne sa źle podane
            NowyDialog.numberDialog();                                              //lub gdy ktoraś wspolrzedna nie jest podana
            error = 1;                              //flaga, ze podano bledne wspolrzedne
        }
    }
}
