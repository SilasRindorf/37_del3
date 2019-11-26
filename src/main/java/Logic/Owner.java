package Logic;
import Entities.Entity_Player;
import Logic.Tiles.Logic_Street;

public class Owner {

    public boolean estateHasOwner(Logic_Street logic_street) {
        if (logic_street.isHasOwner()){
            return true;
        }
        else {
            logic_street.setHasOwner(true);
            return false;
        }
    }
}
