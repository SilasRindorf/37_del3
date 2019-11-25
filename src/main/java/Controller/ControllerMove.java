package Controller;

import Entities.Entity_Player;
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
        Entity_Player playerToMove = playerList.getPlayer(playerID);
        // todo Logic_Chance -> get card -> use in jail
        if(playerToMove.getInJail()){
            if (playerToMove.getchanceOutOfJail()){
                System.out.println("Use Chance card");
                playerToMove.setchanceOutOfJail(false);
                playerToMove.setInJail(false);
            }
            else {
                System.out.println("Pay 2M");
                int newBalance = playerToMove.getBalance() - 2; //get balance and withdraw 2M
                playerToMove.setBalance(newBalance); //setting new balance
                playerToMove.setInJail(false); //taking player out of jail
            }
        }


        movement.move(playerToMove,eyes);
    }
    public Movement getMovement(){
        return movement;
    }
    public void ownership() {
    }
}
