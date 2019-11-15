package Logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    private BufferedReader br;
    private String file;
    public void openFile(String file) throws FileNotFoundException {
        br = new BufferedReader(new FileReader(file));
        this.file = file;
    }
    public int[] ReadInts() throws IOException {
        int[] temp;
        int lines = 0;
        while (br.readLine() != null) {
            lines++;
        }
        temp = new int[lines];
        int i = 0;
        for (String line; (line = br.readLine()) != null; ) {
            temp[i] = Integer.parseInt(line);
            i++;
        }
        return temp;
    }
    public String[] fileToStringArray() throws IOException {
        String[] strings;
        int lines = 0;
        br.mark(100000);
        while (br.readLine() != null) {
            lines++;
        }
        strings = new String[lines];
        br.reset();
        lines = 0;
        for (String line; (line = br.readLine()) != null; ) {
            strings[lines] = line;
            lines++;
        }
        br.reset();
        return strings;
    }
    public int findFirstWord(String string) throws IOException {
        String[] strings = fileToStringArray();
        try {
            for (int j = 0; j < strings.length; j++) {
                if (strings[j].equals(string.toUpperCase()))
                    return j;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    public void closeFile() throws IOException {
        this.br.close();
    }
}