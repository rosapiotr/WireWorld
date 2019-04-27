package main;

import struktury.*;

public class Read {

    private String[] text;

    public Read(String text) {
        this.text = text.split("\n");
    }

    public String[] getText() {
        return text;
    }

    public int[][] read() {

        int[][] tab1 = new int[50][50];

        for (int i = 0; i < text.length; i++) {                 //iteracja po wierszach tablicy w celu znalezienia elementów

            int j = text[i].indexOf(' ');
            if (j == -1)
                continue;

            String word = text[i].substring(0, j);
            String rest = text[i].substring(j + 1);             //rozdzielenie tekstu na element i jego konfigurację

            Element element;
            if (word.equals("Diode:")) {
                element = new Diode(tab1);
                element.insert(rest);
            }

            if (word.equals("ElectronHead:")) {
                element = new ElectronHead(tab1);
                element.insert(rest);
            }

            if (word.equals("ElectronTail:")) {
                element = new ElectronTail(tab1);
                element.insert(rest);
            }

            if (word.equals("XOR:")) {
                element = new XOR(tab1);
                element.insert(rest);
            }

            if (word.equals("Wire:")) {
                element = new Wire(tab1);
                element.insert(rest);
            }

            if (word.equals("Cut:")) {
                element = new Cut(tab1);
                element.insert(rest);
            }

            if (word.equals("OR:")) {
                element = new OR(tab1);
                element.insert(rest);
            }

            if (word.equals("AND:")) {
                element = new AND(tab1);
                element.insert(rest);
            }

            if (word.equals("Repeater:")) {
                element = new Repeater(tab1);
                element.insert(rest);
            }
        }
        return tab1;
    }
}
