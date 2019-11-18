package Logic;

import gui_fields.GUI_Car;
import gui_fields.GUI_Player;
import java.util.Random;
import java.awt.*;

public class Creator {
    public GUI_Car createCar(int maxCurrentPlayers, GUI_Player[] players){

        GUI_Car car = new GUI_Car();
        for (int j = 0; j < maxCurrentPlayers; j++) {
            if (car.getPrimaryColor() == players[j].getCar().getPrimaryColor())
                car = createCar(maxCurrentPlayers,players);
        }
        return car;
    }

    //TODO Betina create unique names
    public String createPlayerName(){
        String str = "";
        return str;
    }
}
