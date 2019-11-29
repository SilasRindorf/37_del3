package Logic;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class MovementTest {
    private final int AMOUNTOFPLAYERS = 4;
    private final int FIELDS = 24;
    Movement movers = new Movement(AMOUNTOFPLAYERS);
    @Test
    public void lotsOfTest(){
        assertFalse(movers.isPassedStart());
        for (int i = 0; i < 10000000; i++) {
            move();
        }
        assertTrue(movers.isPassedStart());

    }

    @Test
    public void move() {
        movers.setAmountOfFields(FIELDS);
        Random rand = new Random();
        int i = rand.nextInt(25);
            for (int playerID = 0; playerID < AMOUNTOFPLAYERS; playerID++) {
                movers.move(playerID,i);
                assertEquals(12,movers.getCarPosition(playerID),12);
                assertEquals(12,i,12);
                movers.setPassedStart(true);

            }
    }

    @Test
        public void isPassedStart(){
        boolean passedStart = movers.isPassedStart();
    }

}