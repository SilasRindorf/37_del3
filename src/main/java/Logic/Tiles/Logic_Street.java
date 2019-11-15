package Logic.Tiles;

//For Bubbi
public class Logic_Street extends Logic_Fields {
    private int propertyPrice;
    private int ownerID;
    private int rent;
    public Logic_Street(String title, String description,int propertyPrice,int rent){
        super(title,description);
        this.propertyPrice = propertyPrice;
        this.rent = rent;
    }
    public void setOwnerID(int ownerID){
        this.ownerID = ownerID;
    }
}
