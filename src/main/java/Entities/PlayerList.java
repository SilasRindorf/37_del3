package Entities;
public class PlayerList {
    private Entity_Player[] players;
    public PlayerList(int playerCount){
        players = new Entity_Player[playerCount];
        for (int i = 0; i < playerCount; i++) {
            players[i] = new Entity_Player(i+1);
        }

    }

    public Entity_Player[] getPlayers() {
        return players;
    }
    public String[] getPlayerNames(){
        String[] str = new String[players.length];
        for (int i = 0; i < players.length; i++){
            str[i] = players[i].getName();
        }
        return str;
    }
    public Entity_Player getPlayer(int playerID){return players[playerID];}
    public void setPlayers(Entity_Player[] players) {
        this.players = players;
    }
}
