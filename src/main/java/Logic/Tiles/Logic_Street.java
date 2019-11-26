package Logic.Tiles;

import java.awt.*;

//For Bubbi & Betina
public class Logic_Street extends Logic_Field {
    private int propertyPrice;
    private int ownerID;
    private boolean hasOwner;
    private int rent;

    public Logic_Street() {
        super("Title","Subtext","Description",0);
    }

     public void setHasOwner(boolean hasOwner){
        this.hasOwner = hasOwner;
     }
     public boolean isHasOwner(){
        return hasOwner;
     }
    public void setOwnerID(int ownerID){
        this.ownerID = ownerID;
    }

    public int getPropertyPrice() {
        return propertyPrice;
    }
    public void setPropertyPrice(int propertyPrice){
        this.propertyPrice = propertyPrice;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }
}
