package Controller;

import Entities.CreateLogicFields;
import Logic.Tiles.*;
import gui_fields.*;

public class ControllerBoard {
    private GUI_Field[] gui_fields;
    public ControllerBoard() throws Exception {
        CreateLogicFields createLogicFields = new CreateLogicFields();
        Logic_Field[] logic_fields = createLogicFields.createNewTiles();
        gui_fields = new GUI_Field[logic_fields.length];
        for (int i = 0; i < logic_fields.length; i++) {
            if (logic_fields[i] instanceof Logic_Street)
                gui_fields[i] = new GUI_Street();
            else if (logic_fields[i] instanceof Logic_Jail)
                gui_fields[i] = new GUI_Jail();
            else if (logic_fields[i] instanceof Logic_Chance)
                gui_fields[i] = new GUI_Chance();
            else if (logic_fields[i] instanceof Logic_Refuge)
                gui_fields[i] = new GUI_Refuge();
            else if (logic_fields[i] instanceof Logic_Start)
                gui_fields[i] = new GUI_Start();
            gui_fields[i].setTitle(logic_fields[i].getTitle());
            gui_fields[i].setSubText(logic_fields[i].getSubText());
            gui_fields[i].setDescription(logic_fields[i].getDescription());
        }
    }

    public GUI_Field[] getGui_fields() {
        return gui_fields;
    }
}
