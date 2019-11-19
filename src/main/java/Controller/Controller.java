package Controller;
import Dice.*;
import Entities.PlayerList;
import Entities.Creator;
import Logic.MoveCar;
import Entities.CreateTiles;
import gui_fields.*;
import gui_main.GUI;

import java.awt.*;

public class Controller {

    public void playGame() throws Exception {
        //Setup for game
        CreateTiles createTiles = new CreateTiles();
        GUI gui = new GUI(createTiles.createNewTiles(),Color.CYAN);
        Creator creator = new Creator();
        Dice dice = new Dice(6);
        GUI_Field[] fields = gui.getFields();

        //Choose language
        String language = gui.getUserSelection("Choose language","English","Danish");
        if (!language.equalsIgnoreCase("english")){
            gui.close();
            fields = createTiles.createNewTiles();
            gui = new GUI(fields, Color.CYAN);
        }
        //Get number of players
        int playerCount = 0;
        while (playerCount > 4 || playerCount < 2)
            playerCount = gui.getUserInteger("Type in number of players (2-4)",2,4);
        PlayerList playerList = new PlayerList(playerCount);
        MoveCar mc = new MoveCar(playerCount);

        //Give players a name
        for (int i = 0; i < playerCount; i++) {
            String name = gui.getUserString("Input " + playerList.getPlayer(i).getName() +  "'s name");
            playerList.getPlayer(i).setName(playerList.getPlayer(i).getName() + " " + name);
            gui.addPlayer(playerList.getPlayer(i));
        }

        //Put players on start
        for (GUI_Player player : playerList.getPlayers()) {
            fields[0].setCar(player, true);
        }
        //TODO Game loop needs refactoring
        //Game loop
        while (true) {
            //Dice throw and move player
            for (GUI_Player player : playerList.getPlayers()) {
                gui.showMessage(player.getName() + " is rolling the dices!");

                dice.rollDice();

                gui.setDie(dice.getEyes());

                mc.move(player, dice.getEyes(), fields);
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
}