package Logic;

import Entities.PlayerList;
import Logic.Tiles.Logic_Field;
import Logic.Tiles.Logic_Street;


public class Sorter {
    private PlayerList playerList;
    private Owner owner = new Owner();
    public void findLogicField(Logic_Field logic_field) {
        //Start
        if (logic_field.getFieldID() == 1) {
        }
        //Chance
        else if (logic_field.getFieldID() == 2){
        }
        //JailVisit
        else if (logic_field.getFieldID() == 3){
        }
        //Parking
        else if (logic_field.getFieldID() == 4){
        }
        //goToJail
        else if (logic_field.getFieldID() == 5){
        }
        //Street
        else if (logic_field.getFieldID() == 6){
            Logic_Street logicStreet = (Logic_Street) logic_field;
            owner.estateHasOwner(logicStreet);
        }

    }
    public void setPlayerList(PlayerList playerList) {
        this.playerList = playerList;
    }
}

