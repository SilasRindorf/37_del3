package Logic.Tiles;
import Logic.ReadFile;
import gui_fields.*;
import java.awt.*;
import java.io.IOException;

public class CreateTiles {
    private GUI_Field[] fields;
    public GUI_Field[] createNewTiles() throws Exception {
        return createNewTiles("english");
    }
    public GUI_Field[] createNewTiles(String language) throws Exception {
        ReadFile rf = new ReadFile();
        rf.openFile("language/" + language + "/createFieldsText.txt");
        GUI_Field[] fields = new GUI_Field[24];
        int j = 0;
        for (int i = 0; i < fields.length; i++) {
            if (i == 0) {
                fields[i] = new GUI_Start();
                setText(fields[i], "start", rf);
                fields[i].setBackGroundColor(Color.green);
            } else if (i == 3 || i == 9 || i == 15 || i == 21) {
                fields[i] = new GUI_Chance();
                setText(fields[i], "chance", rf);
                fields[i].setBackGroundColor(Color.yellow);
            } else if (i == 6) {
                fields[i] = new GUI_Jail();
                setText(fields[i], "jailVisit", rf);
            } else if (i == 12) {
                fields[i] = new GUI_Refuge();
                setText(fields[i], "parking", rf);
            } else if (i == 18) {
                fields[i] = new GUI_Jail();
                setText(fields[i], "goToJail", rf);
            } else {
                fields[i] = new GUI_Street("Kurger Bing", "Subtext", "Description", "200", new Color(59, 49, 1), new Color(255, 255, 255));
                setText(fields[i], "street" + j, rf);
                j++;
            }
        }
        return fields;
    }
    private void setText(GUI_Field fields,String findWord,ReadFile rf) throws IOException {
        int j = rf.findFirstWord(findWord.toUpperCase());
        fields.setTitle(rf.fileToStringArray()[j+1]);
        fields.setSubText(rf.fileToStringArray()[j+2]);
        fields.setDescription(rf.fileToStringArray()[j+3]);
    }
    public void setFields(GUI_Field[] fields){
        this.fields = fields;
    }

    public GUI_Field[] getFields() {
        return fields;
    }
}
