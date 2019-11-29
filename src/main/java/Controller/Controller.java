package Controller;
import  Dice.*;
import Entities.PlayerList;
import Logic.Sorter;
import Logic.ReadFile;
import gui_fields.GUI_Field;
import gui_main.GUI;

import java.awt.*;

public class Controller {
    private final Color BOARDCOLOR = new Color(245, 245, 220);

    public void playGame() throws Exception {
        //Setup for game
        ControllerBoard board = new ControllerBoard();
        GUI gui = new GUI(board.getGui_fields(), BOARDCOLOR);
        Dice dice = new Dice(6);
        Sorter sorter = new Sorter();
        GUI_Field[] fields = gui.getFields();
        ControllerPlayer pc = new ControllerPlayer();
        ReadFile rf = new ReadFile();


        //Choose language
        String language = gui.getUserSelection("Choose language", "English", "Danish");
        if (!language.equalsIgnoreCase("english")) {
            gui.close();
            board.createBoard(language);
            fields = board.getGui_fields();
            gui = new GUI(fields, BOARDCOLOR);
        }
        rf.openFile("language/" + language + "/controllerText.txt");


        //Get number of players
        int playerCount = 0;
        while (playerCount > 4 || playerCount < 2)
            playerCount = gui.getUserInteger(rf.fileToStringArray()[rf.findFirstWord("PLAYERCOUNT") + 1], 2, 4);
        PlayerList playerList = new PlayerList(playerCount);
        pc.setPlayerCount(playerCount);
        ControllerMove cm = new ControllerMove(playerCount);

        //Give players a name
        for (int i = 0; i < playerCount; i++) {
            String name = gui.getUserString("Input player " + playerList.getPlayer(i).getName() + "'s name");
            playerList.getPlayer(i).setName("Player " + playerList.getPlayer(i).getName() + " " + name);
            pc.createGUIPlayer(i, name);
            gui.addPlayer(pc.getPlayers()[i]);
        }
        sorter.setPlayerList(playerList);


        //Put players on start
        for (int i = 0; i < playerList.getPlayers().length; i++) {
            fields[0].setCar(pc.getPlayers()[i], true);
        }


        cm.setGui_field(board.getGui_fields());
        cm.setAmountOfFields(fields.length);
        //Game loop
        while (true) {
            //Dice throw and move player
            for (int i = 0; i < playerList.getPlayers().length; i++) {
                cm.setGui_player(pc.getPlayers()[i]);

                gui.showMessage(playerList.getPlayer(i).getName() + " is rolling the dices!");
                dice.rollDice();
                gui.setDie(dice.getEyes());

                cm.moveCar(i,dice.getEyes());
                //cm.moveCar(i, 18);

                gui.showMessage(gui.getFields()[cm.getMovement().getCarPosition(playerList.getPlayer(i).getId())].getDescription());
                sorter.findLogicField(board.getLogic_fields(), i, cm.getMovement().getCarPosition(i));
                board.colorStreet(cm.getMovement().getCarPosition(i), i, pc.getPlayers()[i].getPrimaryColor());
                if (sorter.isInJail(i)) {
                    cm.moveCar(i, -12);
                    sorter.setInJail(i, false);
                }
                else if (cm.getMovement().isPassedStart()) {
                    playerList.getPlayer(i).setBalance(playerList.getPlayer(i).getBalance() + 200);
                    cm.setPassedStart(false);
                }
                pc.updatePlayer(playerList);
                if (playerList.getPlayer(i).getBalance() <= 0) {
                    gui.showMessage(playerList.getPlayer(i).getName() + " has no money left and lost");
                    int winningPlayerID = 0;
                    for (int j = 0; j < playerList.getPlayers().length; j++) {
                        if (playerList.getPlayer(winningPlayerID).getBalance() < playerList.getPlayer(j).getBalance()) {
                            winningPlayerID = j;
                        }
                    }
                    gui.showMessage(playerList.getPlayer(winningPlayerID).getName() + "has the most money and has won");
                    gui.close();
                    return;
                }
                pc.updatePlayer(playerList);
            }
        }//End of gameloop
    }
}