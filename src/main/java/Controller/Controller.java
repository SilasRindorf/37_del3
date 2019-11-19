package Controller;
import Dice.*;
import Entities.*;
import Logic.MoveCar;
import gui_fields.*;
import gui_main.GUI;

import java.awt.*;

public class Controller {

    public void playGame() throws Exception {
        //Setup for game
        CreateGUITiles createGUITiles = new CreateGUITiles();
        GUI gui = new GUI(createGUITiles.createNewTiles(),Color.CYAN);
        Dice dice = new Dice(6);
        GUI_Field[] fields = gui.getFields();

        //Choose language
        String language = gui.getUserSelection("Choose language","English","Danish");
        if (!language.equalsIgnoreCase("english")){
            gui.close();
            fields = createGUITiles.createNewTiles();
            gui = new GUI(fields, Color.CYAN);
        }
        //Get number of players
        int playerCount = 0;
        while (playerCount > 4 || playerCount < 2)
            playerCount = gui.getUserInteger("Type in number of players (2-4)",2,4);
        PlayerList playerList = new PlayerList(playerCount);
        PlayerController pc = new PlayerController(playerCount,gui);
        //MoveCar mc = new MoveCar(playerCount);

        //Give players a name
        for (int i = 0; i < playerCount; i++) {
            String name = gui.getUserString("Input player " + playerList.getPlayer(i).getName() +  "'s name");
            playerList.getPlayer(i).setName("Player " + playerList.getPlayer(i).getName() + " " + name);
            pc.addPlayers(playerList.getPlayer(i).getName());
            //gui.addPlayer(playerList.getPlayer(i));
        }

        //Put players on start
        for (int i = 0; i < playerList.getPlayers().length; i++) {
            //fields[0].setCar(playerList.getPlayer(i), true);
        }
        //TODO Game loop needs refactoring
        //Game loop
        while (true) {
            //Dice throw and move player
            for (int i=0;i < playerList.getPlayers().length; i++) {
                Entity_Player player = playerList.getPlayer(i);
                gui.showMessage(player.getName() + " is rolling the dices!");

                dice.rollDice();

                gui.setDie(dice.getEyes());

                //mc.move(player, dice.getEyes(), fields);
                //if (mc.isPassedStart())
                  //  player.setBalance(player.getBalance() + 200);

                //gui.showMessage(fields[mc.getCarPosition(player.getId())].getDescription());

                //For testing
                //System.out.println(fields[mc.getCarPosition(player.getNumber())].toString());
                if (player.getBalance() <= 0){
                    return;
                }
            }
        }
    }
}