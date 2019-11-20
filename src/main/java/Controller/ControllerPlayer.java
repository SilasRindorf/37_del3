package Controller;

import Entities.PlayerList;
import gui_fields.GUI_Car;
import gui_fields.GUI_Player;
import gui_main.GUI;

public class ControllerPlayer {
    private GUI GUI;
    private GUI_Player[] players;
    public ControllerPlayer( GUI GUI){
        this.GUI = GUI;
    }

    public void addPlayers(PlayerList playerList){
        players = new GUI_Player[playerList.getPlayers().length];
        for (int i = 0; i < playerList.getPlayers().length; i++) {
            players[i] = new GUI_Player(playerList.getPlayer(i).getName(), playerList.getPlayer(i).getBalance(),createCar(i,players));
            GUI.addPlayer(players[i]);
        }

    }
    public void updatePlayer(PlayerList playerList,int id){
        players[id].setBalance(playerList.getPlayer(id).getBalance());
    }

    public GUI_Player[] getPlayers() {
        return players;
    }

    private GUI_Car createCar(int maxCurrentPlayers, GUI_Player[] players){
        GUI_Car car = new GUI_Car();
        for (int j = 0; j < maxCurrentPlayers; j++) {
            if (car.getPrimaryColor() == players[j].getCar().getPrimaryColor())
                car = createCar(maxCurrentPlayers,players);
        }
        return car;
    }
}
