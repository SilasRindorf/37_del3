package Logic;

import Logic.Tiles.Logic_Field;
import Logic.Tiles.Logic_Street;
import sun.rmi.runtime.Log;

public class Sorter {
    private Owner owner = new Owner();
    public void findLogicField(Logic_Field logic_field) {
        //Start
        if (logic_field.getFieldID() == 1) {
        }
        //Chance
        else if (logic_field.getFieldID() == 2){
        }
        //JailVisit
        else if (logic_field.getFieldID() == 3){
        }
        //Parking
        else if (logic_field.getFieldID() == 4){
        }
        //goToJail
        else if (logic_field.getFieldID() == 5){
        }
        //Street
        else if (logic_field.getFieldID() == 6){
            //owner.estateHasOwner();
            Logic_Street street = (Logic_Street) logic_field;
            System.out.println(street.getOwnerID());
        }

    }

}
