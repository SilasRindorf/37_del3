import gui_fields.GUI_Car;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
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
        for (GUI_Player player : players) {
            fields[0].setCar(player, true);
            mc.move(player, 0, fields);
        }
        //Game loop
        while (true) {
            //Dice throw and move player
            for (GUI_Player player : players) {
                gui.showMessage(player.getName() + " is rolling the dices!");

                dice1.rollDice();
                dice2.rollDice();

                gui.setDice(dice1.getEyes(), dice2.getEyes());
                mc.move(player, dice1.getEyes() + dice2.getEyes(), fields);

                gui.showMessage(fields[mc.getCarPosition(player.getNumber())].getDescription());

                if (player.getBalance() <= 0) {
                    return;
                }

            }
        }
    }
}