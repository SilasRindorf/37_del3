package Logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * This is a class that uses BufferedReader that let's you open a file you choose,
 *
 * read multiple Integers from a document
 *
 * read multiple lines from a document into a String array
 *
 * Search for a specific word in all caps in  a document
 *
 *@author Gruppy 37
 *@version 1.0
 */
public class ReadFile {
    private BufferedReader br;
    /**
     * @param file
     * @throws FileNotFoundException
     *  The method for opening a new file. Has to be called to a valid filepath before other methods can be called
     * <pre>
     *     PRE: A file exists
     *     POST: A BufferedReader is created with the filepath inputted
     * </pre>
     */
    public void openFile(String file) throws FileNotFoundException {
        br = new BufferedReader(new FileReader(file));
    }

    /**
     * Reads from a file from the first line to the last line
     * @return an array of ints
     * @throws IOException
     * <pre>
     *  PRE: A file has Integers to read and a filepath as a String
     *  POST: A Integer array is created from the Integers in the file and returned
     *</pre>
     */
    public int[] ReadInts() throws IOException {
        int[] temp;
        int i = 0;
        br.mark(100000);
        while (br.readLine() != null) {
            i++;
        }
        temp = new int[i];
         i = 0;
        br.reset();
        for (String line; (line = br.readLine()) != null; ) {
            temp[i] = Integer.parseInt(line);
            i++;
        }
        return temp;
    }
    public int readInt(int position) throws IOException {
        int temp= 0;
        br.mark(100000);
        for (int i = 0; i < position; i++) {
            br.readLine();
        }
        temp = br.read();
        System.out.println(temp);
        br.reset();
        return temp;
    }
    public int[] readLineOfInts(int position) throws IOException {
        int j = 0;
        br.mark(100000);
        while (br.readLine() != null) {
            j++;
        }
        br.reset();
        br.mark(100000);
        for (int i = 0; i < j; i++) {
            String tempString = br.readLine();
            if (i == position){
                String[] tempArray = tempString.split(" ");
                int[] temp = new int[tempArray.length];
                for (int k = 0; k < tempArray.length; k++) {
                    temp[k] = Integer.parseInt(tempArray[k]);
                }
                br.reset();
                return temp;
            }
        }
        br.reset();
        return new int[0];
    }

    /**
     * Reads from a file from the first line to the last line
     * @return an array of Strings
     * @throws IOException
     * <pre>
     *  PRE: A file has Text to read and a filepath as a String
     *  POST: A String array is created from the lines in the file and returned
     *</pre>
     */
    public String[] fileToStringArray() throws IOException {
        String[] strings;
        int i = 0;
        br.mark(100000);
        while (br.readLine() != null) {
            i++;
        }
        strings = new String[i];
        br.reset();
        i = 0;
        for (String line; (line = br.readLine()) != null; ) {
            strings[i] = line;
            i++;
        }
        br.reset();
        return strings;
    }
    /**
     * Looks though a file to find a line with the search word in UPPERCASE
     * @return an Integer
     * @throws IOException
     * <pre>
     *  PRE: A file has the search word in UPPERCASE
     *  POST: An Integer is made which is the amount of lines down the search word is
     *</pre>
     */
    public int findFirstWord(String searchWord) throws IOException {
        String[] strings = fileToStringArray();
        try {
            for (int j = 0; j < strings.length; j++) {
                if (strings[j].equals(searchWord.toUpperCase()))
                    return j;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    /**
     * overload findFirstWord, start from a Integer chosen. If the Integer is less than 0 or less than the file length
     * then the Integer is set to 0
     */
    public int findFirstWord(String searchWord,int startLine) throws IOException {
        String[] strings = fileToStringArray();
        if (strings.length < startLine || startLine < 0)
                startLine = 0;
        try {
            for (int j = startLine; j < strings.length; j++) {
                if (strings[j].equals(searchWord.toUpperCase()))
                    return j;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    /**
     * overload findFirstWord, start from a chosen Integer. If the Integer is less than 0 or less than the file length
     * then the Integer is set to 0. Skip the found word a chosen amount of time
     * @return an Integer
     * @throws IOException
     * <pre>
     *  PRE: A file has the search word in UPPERCASE
     *  POST: An Integer is made which is the amount of lines down the search word is
     *</pre>
     */
    public int findWord(String searchWord,int skipAmountOfWords) throws IOException {
        String[] strings = fileToStringArray();
        try {
            int temp = 0;
            for (int j = 0; j < strings.length; j++) {
                if (strings[j].equals(searchWord.toUpperCase()))
                    temp++;
                    if (temp == skipAmountOfWords)
                        return j;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    /**
     * Closes the BufferedReader
     * @throws IOException
     * <pre>
     *  PRE: A BufferedReader has to be open
     *  POST: The BufferedReader is closed
     *</pre>
     */
    public void closeFile() throws IOException {
        br.close();
    }
}