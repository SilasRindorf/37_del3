package Entities;
public class PlayerList {
    private Entity_Player[] players;
    public PlayerList(int playerCount){
        players = new Entity_Player[playerCount];
        for (int i = 0; i < playerCount; i++) {
            players[i] = new Entity_Player(i);
        }

    }
    public Entity_Player[] getPlayers() {
        return players;
    }
    public Entity_Player getPlayer(int playerID){return players[playerID];}
    public void setPlayers(Entity_Player[] players) {
        this.players = players;
    }
}
