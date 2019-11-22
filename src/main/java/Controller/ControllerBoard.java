package Controller;

import Entities.CreateLogicFields;
import Logic.Tiles.*;
import gui_fields.*;
import sun.rmi.runtime.Log;

class ControllerBoard {
    private GUI_Field[] gui_fields;
    ControllerBoard() throws Exception {
        createBoard("english");
    }
    public void createBoard(String language) throws Exception {
        CreateLogicFields createLogicFields = new CreateLogicFields();
        Logic_Field[] logic_fields = createLogicFields.createNewTiles(language);
        gui_fields = new GUI_Field[logic_fields.length];
        for (int i = 0; i < logic_fields.length; i++) {
            if (logic_fields[i] instanceof Logic_Street) {
                GUI_Street guiStreet = new GUI_Street();
                Logic_Street logicStreet = (Logic_Street) logic_fields[i];
                guiStreet.setRent(logicStreet.getRent() + "M");
                guiStreet.setRentLabel(logicStreet.getPropertyPrice() + "M");
                gui_fields[i] = guiStreet;
                gui_fields[i].setBackGroundColor(logic_fields[i].getBackGroundColor());
            }
            else if (logic_fields[i] instanceof Logic_Jail)
                gui_fields[i] = new GUI_Jail();
            else if (logic_fields[i] instanceof Logic_Chance) {
                gui_fields[i] = new GUI_Chance();
                gui_fields[i].setBackGroundColor(logic_fields[i].getBackGroundColor());
            }
            else if (logic_fields[i] instanceof Logic_Refuge)
                gui_fields[i] = new GUI_Refuge();
            else if (logic_fields[i] instanceof Logic_Start)
                gui_fields[i] = new GUI_Start();
            gui_fields[i].setTitle(logic_fields[i].getTitle());
            gui_fields[i].setSubText(logic_fields[i].getSubText());
            gui_fields[i].setDescription(logic_fields[i].getDescription());
        }
    }

    GUI_Field[] getGui_fields() {
        return gui_fields;
    }
}
