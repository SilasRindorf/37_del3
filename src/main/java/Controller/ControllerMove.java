package Controller;

import Entities.PlayerList;
import Logic.Movement;
import gui_fields.GUI_Field;


public class ControllerMove {
    private PlayerList playerList;
    private Movement movement;
    private int amountOfFields;
    private GUI_Field[] gui_field;
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
        for (int i = 1; i < eyes; i++) {
            movement.move(playerID,i);
            try {
                //gui_field[movement.getCarPosition(i)].setCar(playerList.getPlayers()[i],false);
                sleep(500);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public Movement getMovement(){
        return movement;
    }

    public void setGui_field(GUI_Field[] gui_field) {
        this.gui_field = gui_field;
    }

    private void sleep(long miliseconds) throws InterruptedException {
        Thread.sleep(miliseconds);
    }
}
