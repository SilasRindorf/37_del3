package Tiles;
import gui_fields.*;

public class Tile {
    public void determineTile(GUI_Field field){
        if (field.getClass() == GUI_Street.class){
            System.out.println(1);
        }else if (field.getClass() == GUI_Chance.class){
            System.out.println(2);
        }else if(field.getClass() == GUI_Brewery.class){
            System.out.println(3);
        }else if(field.getClass() == GUI_Jail.class){
            System.out.println(4);
        }else if(field.getClass() == GUI_Refuge.class){
            System.out.println(5);
        }else if(field.getClass() == GUI_Shipping.class){
            System.out.println(6);
        }
    }
}
