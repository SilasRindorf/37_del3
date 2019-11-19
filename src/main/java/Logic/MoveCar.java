package Logic;

import Entities.Entity_Player;
import Entities.Entity_Tiles;

public class MoveCar {
    private int[] carPositions;
    private boolean passedStart;
    public MoveCar(int amountOfPlayers){
        carPositions = new int[amountOfPlayers];
    }

    public void move(Entity_Player player, int movement, Entity_Tiles[] fields){
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
