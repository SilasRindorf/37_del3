package Logic;
//No asso
public class Movement {
    private int[] carPositions;
    private boolean passedStart;
    private int amountOfFields;
    public Movement(int amountOfPlayers){
        carPositions = new int[amountOfPlayers];
        for (int i = 0; i < amountOfPlayers; i++) {
            carPositions[i] = 0;
        }

    }
    public void move(int playerID, int movement){
        carPositions[playerID] += movement;
        if (carPositions[playerID] >= amountOfFields){
            carPositions[playerID] -= amountOfFields;
            passedStart = true;
        }
        else {
            passedStart = false;
        }
    }

    public boolean isPassedStart() {
        return passedStart;
    }

    public int getCarPosition(int carID) {
        return carPositions[carID];
    }
    public void setAmountOfFields(int amountOfFields){this.amountOfFields = amountOfFields;}

    public int[] getCarPositions() {
        return carPositions;
    }
}
