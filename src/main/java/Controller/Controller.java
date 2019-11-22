package Controller;
import  Dice.*;
import Entities.PlayerList;
import gui_fields.GUI_Field;
import gui_main.GUI;

import java.awt.*;

public class Controller {
    private final Color boardColor = new Color (245,245,220);

    public void playGame() throws Exception {
        //Setup for game
        ControllerBoard board = new ControllerBoard();
        GUI gui = new GUI(board.getGui_fields(),boardColor);
        Dice dice = new Dice(6);
        GUI_Field[] fields = gui.getFields();


        //Choose language
        String language = gui.getUserSelection("Choose language","English","Danish");
        if (!language.equalsIgnoreCase("english")){
            gui.close();
            board.createBoard(language);
            fields = board.getGui_fields();
            gui = new GUI(fields, boardColor);
        }


        //Get number of players
        int playerCount = 0;
        while (playerCount > 4 || playerCount < 2)
            playerCount = gui.getUserInteger("Type in number of players (2-4)",2,4);
        PlayerList playerList = new PlayerList(playerCount);
        ControllerPlayer pc = new ControllerPlayer(gui);
        //ControllerMove cm = new ControllerMove(playerList);


        //Give players a name
        for (int i = 0; i < playerCount; i++) {
            String name = gui.getUserString("Input player " + playerList.getPlayer(i).getName() +  "'s name");
            playerList.getPlayer(i).setName("Player " + playerList.getPlayer(i).getName() + " " + name);
        }
        pc.addPlayers(playerList);


        //Put players on start
        for (int i = 0; i < playerList.getPlayers().length; i++) {
            fields[0].setCar(pc.getPlayers()[i], true);
        }


        ControllerMove cm = new ControllerMove(playerList);
        cm.getMovement().setAmountOfFields(fields.length);
        cm.setAmountOfFields(fields.length);
        //Game loop
        while (true) {
            //Dice throw and move player
            for (int i=0;i < playerList.getPlayers().length; i++) {

                gui.showMessage(playerList.getPlayer(i).getName() + " is rolling the dices!");
                dice.rollDice();
                gui.setDie(dice.getEyes());

                gui.getFields()[cm.getMovement().getCarPosition(i)].setCar(pc.getPlayers()[i],false);
                cm.moveCar(i,dice.getEyes());

                gui.getFields()[cm.getMovement().getCarPosition(i)].setCar(pc.getPlayers()[i],true);

                gui.showMessage(gui.getFields()[cm.getMovement().getCarPosition(playerList.getPlayer(i).getId())].getDescription());
                pc.updatePlayer(playerList,i);

                if (cm.getMovement().isPassedStart())
                    playerList.getPlayer(i).setBalance(playerList.getPlayer(i).getBalance() + 200);

                if (playerList.getPlayer(i).getBalance() <= 0){
                    gui.showMessage(playerList.getPlayer(i).getName() + " has no money left and lost");
                    return;
                }
            }
        }
    }
}