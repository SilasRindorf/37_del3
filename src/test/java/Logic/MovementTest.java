package Logic;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class MovementTest {
    @Test
    public void lotsOfTest(){
        for (int i = 0; i < 10000000; i++) {
            move();
            isPassedStart();
        }
    }

    @Test
    public void move() {
        final int AMOUNTOFPLAYERS = 4;
        final int FIELDS = 24;
        Movement movers = new Movement(AMOUNTOFPLAYERS);
        movers.setAmountOfFields(FIELDS);
        Random rand = new Random();
        int i = rand.nextInt(24);
            for (int playerID = 0; playerID < AMOUNTOFPLAYERS; playerID++) {
                movers.move(playerID,i);
                assertEquals(12,movers.getCarPosition(playerID),12);
                assertEquals(12,i,12);

            }
    }

    @Test
    public void isPassedStart() {
    }
}