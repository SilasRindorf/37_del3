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
        fields = new Logic_Field[24];
        int streetCount = 0;
        for (int fieldCount = 0; fieldCount < fields.length; fieldCount++) {
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
                fields[fieldCount] = new Logic_Jail(3);
                fields[fieldCount].setFieldID(3);
                setText(fields[fieldCount], "jailVisit");
            } else if (fieldCount == 12) {
                fields[fieldCount] = new Logic_Refuge();
                fields[fieldCount].setFieldID(4);
                setText(fields[fieldCount], "parking");
            } else if (fieldCount == 18) {
                fields[fieldCount] = new Logic_Jail(5);
                fields[fieldCount].setFieldID(5);
                setText(fields[fieldCount], "goToJail");
            } else {

                Logic_Street street = new Logic_Street();
                ReadFile rf1 = new ReadFile();
                rf1.openFile("language/" + "streetProperties.txt");
                street.setPropertyPrice(rf1.readLineOfInts(rf1.findFirstWord("STREET" + streetCount) + 1)[0]);
                street.setRent(rf1.readLineOfInts(rf1.findFirstWord("STREET" + streetCount) + 2)[0]);
                int[] rgbValues = rf1.readLineOfInts(rf1.findFirstWord("STREET" + streetCount) + 3);
                street.setBackGroundColor(new Color(rgbValues[0],rgbValues[1],rgbValues[2]));

                fields[fieldCount] = street;
                fields[fieldCount].setFieldID(6);
                setText(fields[fieldCount], "street" + streetCount);
                streetCount++;
            }
        }
        return fields;
    }

    private void setText(Logic_Field fields, String findWord) throws IOException {
        int j = rf.findFirstWord(findWord.toUpperCase());
        fields.setTitle(rf.fileToStringArray()[j + 1]);
        fields.setSubText(rf.fileToStringArray()[j + 2]);
        fields.setDescription(rf.fileToStringArray()[j + 3]);
    }
}
