package Entities;

import gui_fields.GUI_Player;

public class PlayerList {
    private GUI_Player[] players;
    public PlayerList(GUI_Player[] players){
        this.players = players;
    }

    public GUI_Player[] getPlayers() {
        return players;
    }

    public void setPlayers(GUI_Player[] players) {
        this.players = players;
    }
}
