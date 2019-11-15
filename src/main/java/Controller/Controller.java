package Controller;
import Dice.*;
import Entities.PlayerList;
import Logic.Creator;
import Logic.MoveCar;
import Logic.Tiles.CreateTiles;
import gui_fields.*;
import gui_main.GUI;

import java.awt.*;
import java.io.FileNotFoundException;

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
            gui = new GUI(createTiles.createNewTiles(), Color.CYAN);
        }
        //Get number of players
        int playerCount = gui.getUserInteger("Type in number of players (2-4)",2,4);
        PlayerList playerList = new PlayerList(new GUI_Player[playerCount]);
        MoveCar mc = new MoveCar(playerCount);

        //Initializing players
        for (int i = 0; i < playerCount; i++) {
            String playerName = gui.getUserString("Input player " + (i + 1) + "'s name");
            //If another player already has a Car colored the same as the new car create new car
            GUI_Car car = creator.createCar(i, playerList.getPlayers());
            playerList.getPlayers()[i] = new GUI_Player(playerName, 1000, car);
            gui.addPlayer(playerList.getPlayers()[i]);
        }

        //Put players on start
        for (GUI_Player player : playerList.getPlayers()) {
            fields[0].setCar(player, true);
        }

        //Controller.Controller.Game loop
        while (true) {
            //Dice throw and move player
            for (GUI_Player player : playerList.getPlayers()) {
                gui.showMessage(player.getName() + " is rolling the dices!");

                dice.rollDice();

                gui.setDie(dice.getEyes());

                mc.move(player, dice.getEyes(), fields);
                //TODO change MoveCar, who crosses start and who gets money
                if (mc.isPassedStart())
                    player.setBalance(player.getBalance() + 200);

                gui.showMessage(fields[mc.getCarPosition(player.getNumber())].getDescription());

                //For testing
                System.out.println(fields[mc.getCarPosition(player.getNumber())].toString());
                if (player.getBalance() <= 0){
                    return;
                }

            }
        }
    }

}