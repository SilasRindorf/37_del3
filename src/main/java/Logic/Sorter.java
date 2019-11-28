package Logic;

import Entities.PlayerList;
import Logic.Tiles.Logic_Field;
import Logic.Tiles.Logic_Street;


public class Sorter {
    private PlayerList playerList;
    private boolean jailVisit;
    private int fieldNumber;

    public void findLogicField(Logic_Field[] logic_field, int playerID, int playerPosition) {
        //Start
        if (logic_field[playerPosition].getFieldID() == 1) {
        }
        //Chance
        else if (logic_field[playerPosition].getFieldID() == 2) {
        }
        //JailVisit
        else if (logic_field[playerPosition].getFieldID() == 3) {

        }
        //Parking
        else if (logic_field[playerPosition].getFieldID() == 4) {
        }
        //goToJail
        else if (logic_field[playerPosition].getFieldID() == 5) {
            playerList.getPlayer(playerID).setBalance((playerList.getPlayer(playerID)).getBalance()-200);
        }
        //Street
        else if (logic_field[playerPosition].getFieldID() == 6) {
            Logic_Street logicStreet = (Logic_Street) logic_field[playerPosition];
            if (logicStreet.isHasOwner()) {
                int temp = 1;

                if ((playerPosition + 1) > logic_field.length && logic_field[playerPosition + 1].getFieldID() == 6) {
                    Logic_Street tempStreet = (Logic_Street) logic_field[playerPosition + 1];
                    if (logicStreet.getOwnerID() == tempStreet.getOwnerID()) {
                        temp = 2;
                    }
                } else if (logic_field[playerPosition - 1].getFieldID() == 6) {
                    Logic_Street tempStreet = (Logic_Street) logic_field[playerPosition - 1];
                    if (logicStreet.getOwnerID() == tempStreet.getOwnerID()) {
                        temp = 2;
                    }

                }
                playerList.getPlayer(playerID).setBalance(playerList.getPlayer(playerID).getBalance() - logicStreet.getRent() * temp);
                playerList.getPlayer(logicStreet.getOwnerID()).setBalance(playerList.getPlayer(logicStreet.getOwnerID()).getBalance() + logicStreet.getRent() * temp);

            } else {
                playerList.getPlayer(playerID).setBalance(playerList.getPlayer(playerID).getBalance() - logicStreet.getPropertyPrice());
                logicStreet.setHasOwner(true, playerID);
                setFieldNumber(playerPosition);
            }
        }//End of street

    }

    public void setPlayerList(PlayerList playerList) {
        this.playerList = playerList;
    }
    public void setJailVisit(boolean jailVisit){
        this.jailVisit = jailVisit;
    }

    public int getFieldNumber() {
        return fieldNumber;
    }
    public void setFieldNumber(int fieldNumber){
        this.fieldNumber = fieldNumber;
    }

    public boolean isJailVisit() {
        return jailVisit;
    }
}