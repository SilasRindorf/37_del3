package Controller;

import gui_fields.GUI_Car;
import gui_fields.GUI_Player;
import gui_main.GUI;

public class ControllerPlayer {
    private int amountOfPlayers;
    private GUI GUI;
    public ControllerPlayer(int amountOfPlayers, GUI GUI){
        this.amountOfPlayers = amountOfPlayers;
        this.GUI = GUI;
    }
    public void addPlayers(String name){
        GUI_Player[] players = new GUI_Player[amountOfPlayers];
        for (int i = 0; i < amountOfPlayers; i++) {
            players[i] = new GUI_Player(name, 1000,createCar(i,players));
            GUI.addPlayer(players[i]);
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
