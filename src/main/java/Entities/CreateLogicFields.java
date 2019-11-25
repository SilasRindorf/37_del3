package Entities;
import Logic.ReadFile;
import Logic.Tiles.*;

import java.awt.*;
import java.io.IOException;

public class CreateLogicFields {
    private Logic_Field[] fields;
    private ReadFile rf = new ReadFile();

    public Logic_Field[] createNewTiles() throws Exception {
        return createNewTiles("english");
    }
    public Logic_Field[] createNewTiles(String language) throws Exception {
        rf.openFile("language/" + language + "/createFieldsText.txt");
        final int FIELDSIZE = 24;
        fields = new Logic_Field[FIELDSIZE];
        int streetCount = 0;
        for (int fieldCount = 0; fieldCount < FIELDSIZE; fieldCount++) {
            if (fieldCount == 0) {
                fields[fieldCount] = new Logic_Start();
                fields[fieldCount].setFieldID(1);
                setText(fields[fieldCount], "start");
                fields[fieldCount].setBackGroundColor(Color.green);
            } else if (fieldCount == 3 || fieldCount == 9 || fieldCount == 15 || fieldCount == 21) {
                fields[fieldCount] = new Logic_Chance();
                fields[fieldCount].setFieldID(2);
                setText(fields[fieldCount], "chance");
                fields[fieldCount].setBackGroundColor(Color.yellow);
            } else if (fieldCount == 6) {
                fields[fieldCount] = new Logic_Jail();
                fields[fieldCount].setFieldID(3);
                setText(fields[fieldCount], "jailVisit");
            } else if (fieldCount == 12) {
                fields[fieldCount] = new Logic_Refuge();
                fields[fieldCount].setFieldID(4);
                setText(fields[fieldCount], "parking");
            } else if (fieldCount == 18) {
                fields[fieldCount] = new Logic_Jail();
                fields[fieldCount].setFieldID(5);
                setText(fields[fieldCount], "goToJail");
            } else {
                int[] prices = new int [20];
                for (int k = 0; k < prices.length; k++) {
                    prices[k] = k*10 + 100;
                }
                //fields[i] = new Logic_Street("Kurger Bing", "Subtext", "Description", 200, new Color(59, 49, 1), new Color(255, 255, 255));
                fields[fieldCount] = new Logic_Street();
                fields[fieldCount].setFieldID(6);
                setText(fields[fieldCount], "street" + streetCount);
                Logic_Street street = (Logic_Street) fields[fieldCount];
                street.setPropertyPrice(prices[streetCount]);
                street.setRent(prices[streetCount]/10);
                fields[fieldCount].setBackGroundColor(new Color (rf.findFirstWord("street" + streetCount),rf.findFirstWord("street" + streetCount)*2,(int) (rf.findFirstWord("street" + streetCount)*1.5)));
                streetCount++;
            }
        }
        return fields;
    }
    private void setText(Logic_Field fields, String findWord) throws IOException {
        int j = rf.findFirstWord(findWord.toUpperCase());
        fields.setTitle(rf.fileToStringArray()[j+1]);
        fields.setSubText(rf.fileToStringArray()[j+2]);
        fields.setDescription(rf.fileToStringArray()[j+3]);
    }
    public void setFields(Logic_Field[] fields){
        this.fields = fields;
    }
    public Logic_Field[] getFields() {
        return fields;
    }
}
