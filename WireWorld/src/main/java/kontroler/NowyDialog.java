package kontroler;

import javafx.scene.control.Alert;

public class NowyDialog {

    public static void numberDialog() {                     //dialog dla NumberFormatException
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("NumberFormatExcepion");
        alert.setHeaderText("Błędne współrzędne");
        alert.setContentText("Podano błędne współrzędne dla co najmniej jednego elementu.\nElement ten został pominięty w symulacji");

        alert.showAndWait();
    }

    public static void indexDialog() {                      //dialog dla IndexOutOfBoundsException
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("IndexOutOfBoundsException");
        alert.setHeaderText("Element poza planszą");
        alert.setContentText("Przynajmniej jeden z wstawionych elementów nie zmieścił się na planszy.\n" +
                "Część elementu poza planszą została pominięta");

        alert.showAndWait();
    }

    public static void diodeDialog() {                      //dialog dla StringIndexOutOfBoundsException
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("StringIndexOutOfBoundsException");
        alert.setHeaderText("Błędnie zdefiniowana dioda");
        alert.setContentText("Błędne dane dla diody.\nPodano błędne współrzędne lub nie podano sposobu\nwstawienia diody(Normal lub Reversed)");

        alert.showAndWait();
    }

    public static void informationDialog() {                //dialog informacyjny
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Jak używać");
        alert.setHeaderText("Instrukcja");
        alert.setContentText("Plansza jest rozmiarów 50x50\n" +
                "Przykładowe wstawienie elementów:\nAND: 10 3\nDiode: 10 10 Normal\nElectronTail: 10 3\n" +
                "ElectronHead: 11 3\nOR: 13 20\nRepeater: 3 19\nWire: 25 25 ; 25 35\nCut: 25 25 ; 25 30\nXOR: 35 10\n\n" +
                "Możliwe jest również wstawienie diody odwróconej \"Reversed\"\n" +
                "W przypadku podania błędnych współrzędnych np:\"XOR: 2k 2\"\nelement zostanie pominięty.\n" +
                "W przypadku gdy element nie mieści się na planszy,\nczęść znajdująca się poza planszą znika.");

        alert.showAndWait();
    }

    public static void saveDialog() {                     //dialog dla zapisu
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Save");
        alert.setHeaderText("Pomyślnie zapisano obecną generację");

        alert.showAndWait();
    }

}
