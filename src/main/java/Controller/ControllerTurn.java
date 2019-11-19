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
            GUI.showMessage(player.getName() + " is rolling the dices!");

            dice.rollDice();

            GUI.setDie(dice.getEyes());

            CM.move(player, dice.getEyes(), fields);
            if (mc.isPassedStart())
                player.setBalance(player.getBalance() + 200);

            gui.showMessage(fields[mc.getCarPosition(player.getNumber())].getDescription());

            //For testing
            //System.out.println(fields[mc.getCarPosition(player.getNumber())].toString());
            if (player.getBalance() <= 0){
                return;
            }

        }
    }

}
