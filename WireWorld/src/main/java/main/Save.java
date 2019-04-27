package main;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public abstract class Save {

    public static void save(Read read, Animation animation) {
        String[] saveFile = read.getText();
        PrintWriter save;
        int[][] tab = animation.getTab();
        try {
            save = new PrintWriter("generacja.txt");

            for (String aSaveFile : saveFile) {
                if (!(aSaveFile.contains("ElectronHead") || aSaveFile.contains("ElectronTail")))
                    save.println(aSaveFile);
            }
            for (int row = 0; row < 50; row++)
                for (int column = 0; column < 50; column++) {
                    if (tab[row][column] == 1)
                        save.println("ElectronHead: " + column + " " + row);
                    else if (tab[row][column] == 2)
                        save.println("ElectronTail: " + column + " " + row);
                }
            save.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
