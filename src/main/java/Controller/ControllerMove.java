package Controller;

import Entities.PlayerList;
import Logic.Movement;

public class ControllerMove {
    private PlayerList playerList;
    private Movement movement = new Movement(playerList.getPlayers().length);
    public ControllerMove(PlayerList playerList){
        this.playerList = playerList;
        for (int i = 0; i < playerList.getPlayers().length; i++){
            movement.move(playerList.getPlayer(i),0);
        }
    }
    public void setPlayerList(PlayerList playerList) {
        this.playerList = playerList;
    }
    public void moveCar(int eyes){
        movement = new Movement(playerList.getPlayers().length);
        for (int i = 0; i < playerList.getPlayers().length; i++) {
            movement.move(playerList.getPlayer(i),eyes);
        }
    }
}
