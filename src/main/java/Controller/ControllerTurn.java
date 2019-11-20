package Controller;


import Dice.Dice;
import Entities.PlayerList;
import gui_main.GUI;

public class ControllerTurn {
    private PlayerList playerList;
    private GUI GUI;
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
            ControllerMove CM = new ControllerMove(playerList);
            CM.moveCar(dice.getEyes());
            GUI.showMessage(playerList.getPlayer(i).getName() + " is rolling the dices!");

            dice.rollDice();

            GUI.setDie(dice.getEyes());
            CM.moveCar(dice.getEyes());
            //CM.ControllerMove(player, dice.getEyes(), fields);
            if (CM.getMovement().isPassedStart())
                playerList.getPlayer(i).setBalance(playerList.getPlayer(i).getBalance() + 200);

            GUI.showMessage(GUI.getFields()[CM.getMovement().getCarPosition(playerList.getPlayer(i).getId())].getDescription());

            //For testing
            //System.out.println(fields[mc.getCarPosition(player.getNumber())].toString());
            if (playerList.getPlayer(i).getBalance() <= 0){
                return;
            }

        }
    }

}
