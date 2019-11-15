package Logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class ReadFile {
    private BufferedReader br;
    private String[] strings;
    public void openFile(String file) throws FileNotFoundException {
        br = new BufferedReader(new FileReader(file));
    }
    public String[] getStrings(){
        return strings;
    }
    public int[] ReadInts() throws IOException {
        int[] temp;
        int lines = 0;
        while (br.readLine() != null) lines++;
        temp = new int[lines];
        int i = 0;
        for (String line; (line = br.readLine()) != null; ) {
            temp[i] = Integer.parseInt(line);
            i++;
        }
        return temp;
    }
    public String[] fileToStringArray() throws IOException {
        int lines = 0;
        br.mark(999999);
        while (br.readLine() != null) lines++;
        br.reset();
        strings = new String[lines+1];
        int i = 0;
        for (String line; (line = br.readLine()) !=null;){
            i++;
            strings[i] = line;
        }
        br.reset();
        return strings;
    }
    public int findFirstWord(String string) throws IOException {
        int i = 0;
        if (strings[0] == null)
            fileToStringArray();
        else{
            while(!(strings[i].equals(string)) && i < strings.length) {
                i++;
            }
        }
        return i;
    }
    public void closeFile() throws IOException {
        this.br.close();
    }
}