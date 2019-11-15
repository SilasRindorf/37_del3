package Logic.Tiles;

import gui_fields.GUI_Field;
import gui_fields.GUI_Start;
import gui_fields.GUI_Street;

public class createTiles {
    private GUI_Field[] fields;
    public GUI_Field[] createNewTiles(){
        fields = new GUI_Field[24];
        fields[0] = new GUI_Start();
        return fields;
    }

    public GUI_Field[] getFields() {
        return fields;
    }
}
