package struktury;

import kontroler.NowyDialog;

public abstract class StartElement extends Element {

    public StartElement(int[][] tab1) {
        super(tab1);
    }

    void setXandY(String text) {

        int i = text.indexOf(' ');
        try {
            this.x = Integer.parseInt(text.substring(0, i));
            this.y = Integer.parseInt(text.substring(i + 1));
        } catch (NumberFormatException | StringIndexOutOfBoundsException e) {       //w przypadku gdy wspolrzedne sa źle podane
            NowyDialog.numberDialog();                                              //lub gdy ktoraś wspolrzedna nie jest podana
            error = 1;                      //flaga, ze podano bledne wspolrzedne
        }
    }
}
