package Controller;

import Entities.PlayerList;
import Logic.Movement;

public class ControllerMove {
    private PlayerList playerList;
    private Movement movement;
    private int amountOfFields;
    public ControllerMove(PlayerList playerList){
        this.playerList = playerList;
        movement = new Movement(playerList.getPlayers().length);
        movement.setAmountOfFields(amountOfFields);
    }
    public void setPlayerList(PlayerList playerList) {
        this.playerList = playerList;
    }
    public void setAmountOfFields(int amountOfFields){
        this.amountOfFields = amountOfFields;
    }
    public void moveCar(int playerID,int eyes){
        movement.move(playerList.getPlayer(playerID),eyes);
    }
    public Movement getMovement(){
        return movement;
    }
}
