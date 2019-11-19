package Entities;
import gui_fields.GUI_Car;
import gui_fields.GUI_Player;
public class PlayerList {
    private GUI_Player[] players;
    public PlayerList(int playerCount){
        players =  new GUI_Player[playerCount];
        Creator creator = new Creator();
        for(int i = 0; i < players.length; i++){
            GUI_Car car = creator.createCar(i, players);
            players[i] = new GUI_Player("Player " + (i+1),1000,car);
        }
    }

    public GUI_Player[] getPlayers() {
        return players;
    }
    public GUI_Player getPlayer(int playerID){return players[playerID];}
    public void setPlayers(GUI_Player[] players) {
        this.players = players;
    }
}
