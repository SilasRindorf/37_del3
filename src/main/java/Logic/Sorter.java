package Logic;

import Entities.PlayerList;
import Logic.Tiles.Logic_Field;
import Logic.Tiles.Logic_Street;


public class Sorter {
    private PlayerList playerList;
    public void findLogicField(Logic_Field[] logic_field, int playerID, int playerPosition) {
        //Start
        if (logic_field[playerPosition].getFieldID() == 1) {
        }
        //Chance
        else if (logic_field[playerPosition].getFieldID() == 2){
        }
        //JailVisit
        else if (logic_field[playerPosition].getFieldID() == 3){
        }
        //Parking
        else if (logic_field[playerPosition].getFieldID() == 4){
        }
        //goToJail
        else if (logic_field[playerPosition].getFieldID() == 5){
        }
        //Street
        else if (logic_field[playerPosition].getFieldID() == 6){
            Logic_Street logicStreet = (Logic_Street) logic_field[playerPosition];
            if (logicStreet.isHasOwner()){
                playerList.getPlayer(playerID).setBalance(playerList.getPlayer(playerID).getBalance()-logicStreet.getRent());
                
            }
                
            
        }

    }
    public void setPlayerList(PlayerList playerList) {
        this.playerList = playerList;
    }
    
}


