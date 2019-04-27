package Tests;

import main.ReadFile;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.File;

public class ReadFileTest {
    @Test
    public void testRead() {
        File file = new File("src/test/java/resources/test.txt");
        ReadFile readFile = new ReadFile(file);
        String text = readFile.read();
        assertTrue((text.equals("Diode: 8 12\nXOR: 11 21\n")));
    }
}
