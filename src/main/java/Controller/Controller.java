package Controller;
import Dice.*;
import Entities.Players;
import Logic.MoveCar;
import gui_fields.*;
import gui_main.GUI;

public class Controller {

    public void playGame() {
        //Setup for game
        GUI gui = new GUI();
        Dice dice = new Dice(6);
        GUI_Field[] fields = gui.getFields();

        //Get number of players
        int playerCount = gui.getUserInteger("Type in number of players (2-4)",2,4);
        Players players = new Players(new GUI_Player[playerCount]);
        MoveCar mc = new MoveCar(playerCount);

        //Initializing players
        for (int i = 0; i < playerCount; i++) {
            String playerName = gui.getUserString("Input player " + (i + 1) + "'s name");
            //If another player already has a Car colored the same as the new car create new car
            GUI_Car car = createCar(i,players.getPlayers());
            players.getPlayers()[i] = new GUI_Player(playerName, 1000, car);
            gui.addPlayer(players.getPlayers()[i]);
        }

        //Put players on start
        for (GUI_Player player : players.getPlayers()) {
            fields[0].setCar(player, true);
        }

        //Controller.Controller.Game loop
        while (true) {
            //Dice throw and move player
            for (GUI_Player player : players.getPlayers()) {
                gui.showMessage(player.getName() + " is rolling the dices!");

                dice.rollDice();

                gui.setDie(dice.getEyes());

                mc.move(player, dice.getEyes(), fields);
                //TODO change MoveCar, who crosses start and who gets money
                if (mc.isPassedStart())
                    player.setBalance(player.getBalance() + 200);

                gui.showMessage(fields[mc.getCarPosition(player.getNumber())].getDescription());

                //todo Tile needs refactoring


                //For testing
                System.out.println(fields[mc.getCarPosition(player.getNumber())].toString());
                if (player.getBalance() <= 0){
                    return;
                }

            }
        }
    }
    private GUI_Car createCar(int maxCurrentPlayers,GUI_Player[] players){
        GUI_Car car = new GUI_Car();
        for (int j = 0; j < maxCurrentPlayers; j++) {
            if (car.getPrimaryColor() == players[j].getCar().getPrimaryColor())
                car = createCar(maxCurrentPlayers,players);
        }
        return car;
    }
}