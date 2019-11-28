package Logic;

import Entities.Entity_Player;
import Entities.PlayerList;


public class Move {
    private PlayerList playerList;
    private Movement movement;
    private int amountOfFields;
    public Move(PlayerList playerList){
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
        Entity_Player playerToMove = playerList.getPlayer(playerID);

        movement.move(playerToMove,eyes);
    }
    public Movement getMovement(){
        return movement;
    }
}
