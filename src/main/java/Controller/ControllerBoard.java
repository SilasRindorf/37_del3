package Controller;

import Entities.CreateLogicFields;
import Logic.Tiles.Logic_Street;
import gui_fields.*;

import java.awt.*;

public class ControllerBoard {
    private GUI_Field[] gui_fields;
    private CreateLogicFields clf = new CreateLogicFields();
    ControllerBoard() throws Exception {
        createBoard("english");
    }
    public void createBoard(String language) throws Exception {
        clf.createNewTiles(language);
        gui_fields = new GUI_Field[clf.getFields().length];
        for (int i = 0; i < clf.getFields().length; i++) {
            if (clf.getFields()[i].getFieldID() == 6) {
                GUI_Street guiStreet = new GUI_Street();
                Logic_Street logicStreet = (Logic_Street) clf.getFields()[i];
                guiStreet.setRent(logicStreet.getRent() + "M");
                guiStreet.setRentLabel(logicStreet.getPropertyPrice() + "M");
                gui_fields[i] = guiStreet;
                gui_fields[i].setBackGroundColor(clf.getFields()[i].getBackGroundColor());
            }
            else if (clf.getFields()[i].getFieldID() == 3 || clf.getFields()[i].getFieldID() == 5)
                gui_fields[i] = new GUI_Jail();
            else if (clf.getFields()[i].getFieldID() == 2) {
                gui_fields[i] = new GUI_Chance();
                gui_fields[i].setBackGroundColor(clf.getFields()[i].getBackGroundColor());
            }
            else if (clf.getFields()[i].getFieldID() == 4)
                gui_fields[i] = new GUI_Refuge();
            else if (clf.getFields()[i].getFieldID() == 1)
                gui_fields[i] = new GUI_Start();
            gui_fields[i].setTitle(clf.getFields()[i].getTitle());
            gui_fields[i].setSubText(clf.getFields()[i].getSubText());
            gui_fields[i].setDescription(clf.getFields()[i].getDescription());
        }
    }
    public void colorStreet(int placementID, int playerID, Color playerColor){
        if (clf.getFields()[placementID].getFieldID() == 6) {
            Logic_Street logic_street = (Logic_Street) clf.getFields()[placementID];
            if (logic_street.getOwnerID() == playerID){
                GUI_Street gui_street = (GUI_Street) gui_fields[placementID];
                gui_street.setBorder(playerColor);
            }
        }
    }

    GUI_Field[] getGui_fields() {
        return gui_fields;
    }

    public CreateLogicFields getClf() {
        return clf;
    }
}
