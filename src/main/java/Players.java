import gui_fields.GUI_Player;

public class Players {
    private GUI_Player[] players;
    public Players(GUI_Player[] players){
        this.players = players;
    }

    public GUI_Player[] getPlayers() {
        return players;
    }

    public void setPlayers(GUI_Player[] players) {
        this.players = players;
    }
}
