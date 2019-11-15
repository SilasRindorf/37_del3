package Logic.Tiles;
import Logic.ReadFile;
import gui_fields.*;
import java.awt.*;

public class CreateTiles {
    private GUI_Field[] fields;
    public GUI_Field[] createNewTiles() throws Exception {
        return createNewTiles("english");
    }
    public GUI_Field[] createNewTiles(String language) throws Exception {
        ReadFile rf = new ReadFile();
        rf.openFile("language/" + language + "/createFieldsText.txt");
        GUI_Field[] tempFields = new GUI_Field[24];
        int j = 0;
        for (int i = 0; i < tempFields.length; i++) {
            if (i == 0){
                tempFields[0] = new GUI_Start();
                j = rf.findFirstWord("START");
                System.out.println(j);
                System.out.println(rf.getStrings()[j]);
                tempFields[0].setTitle(rf.fileToStringArray()[j+1]);
                tempFields[0].setSubText(rf.fileToStringArray()[j+2]);
            }
            else if(i == 3 || i == 9 || i == 15 || i == 21) {
                tempFields[i] = new GUI_Chance();
                tempFields[i].setTitle("Chance card");
            }
            else if (i == 6){
                tempFields[i] =  new GUI_Jail();
                tempFields[i].setSubText("Jail");
            }
            else if (i == 12){
                tempFields[i] = new GUI_Refuge();
                tempFields[i].setSubText("Parking");
            }
            else if (i == 18){
                tempFields[i] = new GUI_Jail();
                tempFields[i].setSubText("Jail");
            }
            else
                tempFields[i] = new GUI_Street("Kurger Bing","Subtext","Description","200",new Color(59,49,1),new Color(255,255,255));
        }
        return tempFields;
    }
    public void setFields(GUI_Field[] fields){
        this.fields = fields;
    }

    public GUI_Field[] getFields() {
        return fields;
    }
}
