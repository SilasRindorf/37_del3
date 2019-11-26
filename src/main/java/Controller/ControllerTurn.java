package Controller;


import Dice.Dice;
import Entities.PlayerList;
import Logic.Move;

public class ControllerTurn {
    private PlayerList playerList;
    public ControllerTurn(PlayerList playerList){
        this.playerList = playerList;
    }
    public void setPlayerList(PlayerList playerList) {
        this.playerList = playerList;
    }

    public PlayerList getPlayerList() {
        return playerList;
    }

    public void turn(){
        //Dice throw and move player
        for (int i = 0; i < playerList.getPlayers().length;i++) {
            Dice dice = new Dice(6);
            Move CM = new Move(playerList);


            dice.rollDice();

            CM.moveCar(i,dice.getEyes());

            if (CM.getMovement().isPassedStart())
                playerList.getPlayer(i).setBalance(playerList.getPlayer(i).getBalance() + 200);


            //For testing
            //System.out.println(fields[mc.getCarPosition(player.getNumber())].toString());
            if (playerList.getPlayer(i).getBalance() <= 0){
                return;
            }

        }
    }

}
