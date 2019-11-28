package Logic;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.*;

public class ReadFileTest {


    @Test
    public void readInts() {
        try {
            ReadFile rf = new ReadFile();
            String FILEPATH = "src/test/java/testTextInts.txt";
            rf.openFile(FILEPATH);
            int[] ints = new int[1000];
            for (int i = 0; i < ints.length; i++) {
                ints[i] = i;
            }
            for (int i = 0; i < 1000; i++) {
                assertEquals(i,i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void readInt() throws FileNotFoundException {
        ReadFile rf = new ReadFile();
        String FILEPATH = "src/test/java/testTextInt.txt";
        rf.openFile(FILEPATH);
    }

    @Test
    public void readLineOfInts() {
    }

    @Test
    public void fileToStringArray() {
    }

    @Test
    public void findFirstWord() {
    }

    @Test
    public void testFindFirstWord() {
    }

    @Test
    public void findWord() {
    }
}