package Logic.Tiles;

import java.awt.*;

//For Bubbi
//Jeg(Silas) har lavet de mest basic ting i klassen for at koden kan køre
public class Logic_Street extends Logic_Field {
    private int propertyPrice;
    private int ownerID;
    private int rent;
    public Logic_Street(String title,String subtext, String description){
        super(title,subtext,description);
    }
    public Logic_Street(String title,String subtext, String description,int propertyPrice,int rent){
        super(title,subtext,description);
        this.propertyPrice = propertyPrice;
        this.rent = rent;
    }
    public Logic_Street(String title, String subtext, String description, Color backGroundColor, Color border){
        super(title,subtext,description,backGroundColor,border);
    }
    public Logic_Street(String title, String subtext, String description,int propertyPrice, Color backGroundColor, Color border){
        super(title,subtext,description,backGroundColor,border);
    }
    public Logic_Street(String title, String subtext, String description, int propertyPrice, int rent, Color backGroundColor, Color border){
        super(title,subtext,description,backGroundColor,border);
        this.propertyPrice = propertyPrice;
        this.rent = rent;
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
