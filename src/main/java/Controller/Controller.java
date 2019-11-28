package Controller;
import  Dice.*;
import Entities.PlayerList;
import Logic.Move;
import Logic.Sorter;
import Logic.ReadFile;
import Logic.Tiles.Logic_Field;
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
        //
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
        ControllerPlayer pc = new ControllerPlayer(gui);

        //Give players a name
        for (int i = 0; i < playerCount; i++) {
            String name = gui.getUserString("Input player " + playerList.getPlayer(i).getName() + "'s name");
            playerList.getPlayer(i).setName("Player " + playerList.getPlayer(i).getName() + " " + name);
        }
        pc.addPlayers(playerList);
        sorter.setPlayerList(playerList);


        //Put players on start
        for (int i = 0; i < playerList.getPlayers().length; i++) {
            fields[0].setCar(pc.getPlayers()[i], true);
        }


        Move cm = new Move(playerList);
        cm.getMovement().setAmountOfFields(fields.length);
        cm.setAmountOfFields(fields.length);
        //Game loop
        while (true) {
            //Dice throw and move player
            for (int i = 0; i < playerList.getPlayers().length; i++) {

                gui.showMessage(playerList.getPlayer(i).getName() + " is rolling the dices!");
                dice.rollDice();
                gui.setDie(dice.getEyes());

                gui.getFields()[cm.getMovement().getCarPosition(i)].setCar(pc.getPlayers()[i], false);
                cm.moveCar(i, dice.getEyes());

                gui.getFields()[cm.getMovement().getCarPosition(i)].setCar(pc.getPlayers()[i], true);
                sorter.findLogicField(board.getLogic_fields(), i, cm.getMovement().getCarPosition(i));


                gui.showMessage(gui.getFields()[cm.getMovement().getCarPosition(playerList.getPlayer(i).getId())].getDescription());
                //estateHasOwner.setLogicStreet(board.getLogic_fields());
                if (cm.getMovement().isPassedStart())
                    playerList.getPlayer(i).setBalance(playerList.getPlayer(i).getBalance() + 200);
                pc.updatePlayer(playerList, i);
                if (playerList.getPlayer(i).getBalance() <= 0) {
                    gui.showMessage(playerList.getPlayer(i).getName() + " has no money left and lost");
                    int winningPlayerID = 0;
                    for (int j = 0; j < playerList.getPlayers().length; j++) {
                        if (playerList.getPlayer(winningPlayerID).getBalance() < playerList.getPlayer(j).getBalance()) {
                            winningPlayerID = j;
                        }
                    }
                    gui.showMessage(playerList.getPlayer(winningPlayerID).getName() + "has the most money and has won");
                    return;
                }
            }
        }
    }
}