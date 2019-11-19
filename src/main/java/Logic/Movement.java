package Logic;

import Entities.Entity_Player;
import Entities.Entity_Tiles;

public class Movement {
    private int[] carPositions;
    private boolean passedStart;
    private Entity_Tiles[] fields;
    public Movement(int amountOfPlayers){
        carPositions = new int[amountOfPlayers];
    }
    public void move(Entity_Player player, int movement){
        //fields[carPositions[player.getId()]].setCar(player,false);
        carPositions[player.getId()] += movement;
        if (carPositions[player.getId()] >= fields.length){
            carPositions[player.getId()] -= fields.length;
            passedStart = true;
        }
        else
            passedStart = false;
        //fields[carPositions[player.getId()]].setCar(player, true);
    }

    public Entity_Tiles[] getFields() {
        return fields;
    }

    public void setFields(Entity_Tiles[] fields) {
        this.fields = fields;
    }

    public boolean isPassedStart() {
        return passedStart;
    }

    public int getCarPosition(int carID) {
        return carPositions[carID];
    }

    public int[] getCarPositions() {
        return carPositions;
    }
}
