package Logic;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.*;

public class ReadFileTest {


    @Test
    public void readLineOfInts() throws IOException {
        ReadFile rf = new ReadFile();
        String FILEPATH = "src/test/java/testLineOfInts.txt";
        rf.openFile(FILEPATH);
        int[][] ints = new int[1000][];
        for (int i = 0; i < 1000; i++) {
            ints[i] = rf.readLineOfInts(i);
        }
        for (int i = 0; i < ints.length; i++) {
            for (int k = 0; k < ints[i].length; k++) {
                int temp = i;
                if (k > 0)
                    temp *= 10;
                assertEquals(temp,ints[i][k]);
            }
        }
    }

    @Test
    public void fileToStringArray() throws IOException {
        ReadFile rf = new ReadFile();
        String FILEPATH = "src/test/java/testLineOfInts.txt";
        rf.openFile(FILEPATH);
        String[] str = new String [1000];
        for (int i = 0; i < 1000; i++) {
            str[i] = i + " " + (i*10);
        }
        for (int i = 0; i < str.length ; i++) {
            assertEquals(str[i],rf.fileToStringArray()[i]);
        }
    }

    @Test
    public void findFirstWord() throws IOException {
        ReadFile rf = new ReadFile();
        String FILEPATH = "src/test/java/testFindWord.txt";
        rf.openFile(FILEPATH);
        int position = 56;
        assertEquals(position, rf.findFirstWord("CDIO"));
    }
}