import gui_fields.*;
import gui_main.GUI;

public class Game {
    public void playGame() {
        //Setup for game
        GUI gui = new GUI();
        Dice dice1 = new Dice(6);
        Dice dice2 = new Dice(6);
        GUI_Field[] fields = gui.getFields();

        //Get number of players
        int playerCount = gui.getUserInteger("Type in number of players (2-4)");
        while (playerCount < 2 || playerCount > 4)
            playerCount = gui.getUserInteger("Not a valid number, please input a number between 2 and 4");
        GUI_Player[] players = new GUI_Player[playerCount];
        MoveCar mc = new MoveCar(playerCount);

        //Initializing players
        for (int i = 0; i < players.length; i++) {
            String playerName = gui.getUserString("Input player " + (i + 1) + "'s name");
            players[i] = new GUI_Player(playerName, 1000, new GUI_Car());
            gui.addPlayer(players[i]);
        }

        //Put players on start
        for (int i = 0; i < players.length; i++) {
            fields[0].setCar(players[i], true);
            mc.move(players[i], 0, fields);
        }

        while (true)
            //Dice throw and move player
            for (int i = 0; i < players.length; i++) {
                gui.showMessage(players[i].getName() + " is rolling the dices!");

                dice1.rollDice();
                dice2.rollDice();

                gui.setDice(dice1.getEyes(), dice2.getEyes());

                mc.move(players[i], dice1.getEyes() + dice2.getEyes(), fields);

                if (players[i].getBalance() >= 3000){
                    break;
                }

            }
    }
}