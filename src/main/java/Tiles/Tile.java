package Tiles;
import gui_fields.*;

public class Tile {
    public void determineTile(GUI_Field field){
        if (field.getClass() == GUI_Street.class){
            new Street().encounter();
        }else if (field.getClass() == GUI_Chance.class){
            new Chance().encounter();
        }else if(field.getClass() == GUI_Brewery.class){
            new Brewery().encounter();
        }else if(field.getClass() == GUI_Jail.class){
            new Jail().encounter();
        }else if(field.getClass() == GUI_Refuge.class){
            new Refuge().encounter();
        }else if(field.getClass() == GUI_Shipping.class){
            new Shipping().encounter();
        }
    }
}
