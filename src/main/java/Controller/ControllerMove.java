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
        movement.setAmountOfFields(amountOfFields);
    }
    public void moveCar(int playerID,int eyes){
        if (eyes <= 0){
            //gui_field[movement.getCarPosition(playerID)].setCar(gui_player, false);
            for (int i = 0; i > eyes; i--) {
                mover(eyes,playerID);
            }
            //gui_field[6].setCar(gui_player, true);
        }
        else {
            for (int i = 0; i < eyes; i++) {
                mover(1,playerID);
            }
        }
    }
    private void mover(int moves, int playerID){
        gui_field[movement.getCarPosition(playerID)].setCar(gui_player, false);
        if (moves <= 0)
            movement.move(playerID,-1);
        else
            movement.move(playerID, 1);
        try {
            gui_field[movement.getCarPosition(playerID)].setCar(gui_player, true);
            sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
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
    public void setPassedStart(boolean passedStart){
        movement.setPassedStart(passedStart);
    }
}
