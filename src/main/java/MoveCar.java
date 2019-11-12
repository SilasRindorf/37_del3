import gui_fields.GUI_Field;
import gui_fields.GUI_Player;

public class MoveCar {
    private int[] carPositions;
    private boolean passedStart;
    public MoveCar(int amountOfPlayers){
        carPositions = new int[amountOfPlayers];
    }
    public void move(GUI_Player player, int movement, GUI_Field[] fields){
        fields[carPositions[player.getNumber()]].setCar(player,false);
        carPositions[player.getNumber()] += movement;
        if (carPositions[player.getNumber()] >= fields.length){
            carPositions[player.getNumber()] -= fields.length;
            passedStart = true;
        }
        else
            passedStart = false;
        fields[carPositions[player.getNumber()]].setCar(player, true);
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
