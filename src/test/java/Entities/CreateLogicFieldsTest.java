package Entities;


import Logic.Tiles.Logic_Field;
import Logic.Tiles.Logic_Start;
import org.junit.Test;
import static org.junit.Assert.*;

public class CreateLogicFieldsTest {
    private Logic_Field[] logicField;

    @Test
    public void createNewTiles() {
        CreateLogicFields clf = new CreateLogicFields();
        try {

            logicField = clf.createNewTiles();
        }catch (Exception e){
            e.printStackTrace();
        }
        for (int i = 0; i < logicField.length; i++) {
            if(i == 0) {
                assertEquals(logicField[0].getFieldID(), 1);
            }
            else if(i == 3 || i == 9 || i == 15 || i == 21)
                assertEquals(logicField[i].getFieldID(),2);
            else if(i == 6){
                assertEquals(logicField[i].getFieldID(),3);
            }
            else if(i == 12){
                assertEquals(logicField[i].getFieldID(),4);
            }
            else if(i == 18){
                assertEquals(logicField[i].getFieldID(),5);
            }
            else{
                assertEquals(logicField[i].getFieldID(),6);
            }


        }

    }

    @Test
    public void getFields() {
    }
}
