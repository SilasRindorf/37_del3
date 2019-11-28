package Controller;

import Entities.CreateLogicFields;
import Logic.Tiles.Logic_Field;
import Logic.Tiles.Logic_Street;
import gui_fields.*;

public class ControllerBoard {
    private GUI_Field[] gui_fields;
    private Logic_Field[] logic_fields;
    ControllerBoard() throws Exception {
        createBoard("english");
    }
    public void createBoard(String language) throws Exception {
        CreateLogicFields createLogicFields = new CreateLogicFields();
        logic_fields = createLogicFields.createNewTiles(language);
        gui_fields = new GUI_Field[logic_fields.length];
        for (int i = 0; i < logic_fields.length; i++) {
            if (logic_fields[i].getFieldID() == 6) {
                GUI_Street guiStreet = new GUI_Street();
                Logic_Street logicStreet = (Logic_Street) logic_fields[i];
                guiStreet.setRent(logicStreet.getRent() + "M");
                guiStreet.setRentLabel(logicStreet.getPropertyPrice() + "M");
                gui_fields[i] = guiStreet;
                gui_fields[i].setBackGroundColor(logic_fields[i].getBackGroundColor());
            }
            else if (logic_fields[i].getFieldID() == 3 || logic_fields[i].getFieldID() == 5)
                gui_fields[i] = new GUI_Jail();
            else if (logic_fields[i].getFieldID() == 2) {
                gui_fields[i] = new GUI_Chance();
                gui_fields[i].setBackGroundColor(logic_fields[i].getBackGroundColor());
            }
            else if (logic_fields[i].getFieldID() == 4)
                gui_fields[i] = new GUI_Refuge();
            else if (logic_fields[i].getFieldID() == 1)
                gui_fields[i] = new GUI_Start();
            gui_fields[i].setTitle(logic_fields[i].getTitle());
            gui_fields[i].setSubText(logic_fields[i].getSubText());
            gui_fields[i].setDescription(logic_fields[i].getDescription());
        }
    }

    GUI_Field[] getGui_fields() {
        return gui_fields;
    }
    Logic_Field[] getLogic_fields(){return logic_fields;}
}
