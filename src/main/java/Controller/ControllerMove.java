package Controller;

import Entities.PlayerList;
import Logic.Movement;

public class ControllerMove {
    private PlayerList playerList;
    private Movement movement;
    public ControllerMove(PlayerList playerList){
        this.playerList = playerList;
        movement = new Movement(playerList.getPlayers().length);
        for (int i = 0; i < playerList.getPlayers().length; i++){
            movement.move(playerList.getPlayer(i),0);
        }
    }
    public void setPlayerList(PlayerList playerList) {
        this.playerList = playerList;
    }
    public void moveCar(int eyes){
        for (int i = 0; i < playerList.getPlayers().length; i++) {
            movement.move(playerList.getPlayer(i),eyes);
        }
    }
    public Movement getMovement(){
        return movement;
    }
}
