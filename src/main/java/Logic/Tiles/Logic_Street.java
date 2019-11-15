package Logic.Tiles;

public class Logic_Street extends Logic_Fields {
    private int propertyPrice;
    public Logic_Street(String title, String description,int propertyPrice){
        super(title,description);
        this.propertyPrice = propertyPrice;
    }
}
