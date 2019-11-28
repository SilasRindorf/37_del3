package Controller;

import Entities.PlayerList;
import gui_fields.GUI_Car;
import gui_fields.GUI_Player;

public class ControllerPlayer {
    private GUI_Player[] players;

    public void createGUIPlayer(int playerID, String name) {
        players[playerID] = new GUI_Player("Player " + playerID + " " + name, 1000, createCar(playerID));
    }

    public void updatePlayer(PlayerList playerList) {
        for (int i = 0; i < playerList.getPlayers().length; i++) {
            players[i].setBalance(playerList.getPlayer(i).getBalance());
        }


    }

    private GUI_Car createCar(int playerID) {
        GUI_Car car = new GUI_Car();
        for (int j = 0; j < playerID; j++) {
            if (car.getPrimaryColor() == players[j].getCar().getPrimaryColor())
                car = createCar(playerID);
        }
        return car;
    }

    public GUI_Player[] getPlayers() {
        return players;
    }


    public void setPlayerCount(int playerCount) {
        players = new GUI_Player[playerCount];
    }
}