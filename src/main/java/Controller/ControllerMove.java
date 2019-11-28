package Controller;

import Logic.Movement;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;


public class ControllerMove {
    private Movement movement;
    private int amountOfFields;
    private GUI_Field[] gui_field;
    private GUI_Player gui_player;
    public ControllerMove(int amountOfPlayers){
        movement = new Movement(amountOfPlayers);
        movement.setAmountOfFields(amountOfFields);
    }
    public void setAmountOfFields(int amountOfFields){
        this.amountOfFields = amountOfFields;
    }
    public void moveCar(int playerID,int eyes){
        for (int i = 1; i <= eyes; i++) {
            movement.move(playerID,1);
            try {
                gui_field[movement.getCarPosition(playerID)-1].setCar(gui_player,false);
                sleep(500);
                gui_field[movement.getCarPosition(playerID)].setCar(gui_player,true);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public Movement getMovement(){
        return movement;
    }

    public void setGui_player(GUI_Player gui_player) {
        this.gui_player = gui_player;
    }

    public void setGui_field(GUI_Field[] gui_field) {
        this.gui_field = gui_field;
    }

    private void sleep(long miliseconds) throws InterruptedException {
        Thread.sleep(miliseconds);
    }
}
