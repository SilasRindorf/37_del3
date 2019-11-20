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
        int j = 0;
        for (int i = 0; i < FIELDSIZE; i++) {
            if (i == 0) {
                fields[i] = new Logic_Start();
                setText(fields[i], "start");
                fields[i].setBackGroundColor(Color.green);
            } else if (i == 3 || i == 9 || i == 15 || i == 21) {
                fields[i] = new Logic_Chance();
                setText(fields[i], "chance");
                fields[i].setBackGroundColor(Color.yellow);
            } else if (i == 6) {
                fields[i] = new Logic_Jail();
                setText(fields[i], "jailVisit");
            } else if (i == 12) {
                fields[i] = new Logic_Refuge();
                setText(fields[i], "parking");
            } else if (i == 18) {
                fields[i] = new Logic_Jail();
                setText(fields[i], "goToJail");
            } else {
                //fields[i] = new Logic_Street("Kurger Bing", "Subtext", "Description", 200, new Color(59, 49, 1), new Color(255, 255, 255));
                fields[i] = new Logic_Street();
                setText(fields[i], "street" + j);
                fields[i].setBackGroundColor(new Color (rf.findFirstWord("street" + j),rf.findFirstWord("street" + j)*2,(int) (rf.findFirstWord("street" + j)*1.5)));
                j++;
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
