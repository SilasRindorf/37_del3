package Entities.Tiles;
import gui_fields.*;
import gui_main.GUI;
public class Tile {
    private GUI gui;

    public Tile(GUI gui) {
        this.gui = gui;
    }
    public void determineTile(GUI_Field field, GUI_Player player) {
        if (field.getClass() == GUI_Street.class) {
            new Street().encounter(gui,(GUI_Street) field,player);
        } else if (field.getClass() == GUI_Shipping.class) {
            new Shipping().encounter(gui,(GUI_Shipping) field,player);
        } else if (field.getClass() == GUI_Refuge.class) {
            new Refuge().encounter();
        } else if (field.getClass() == GUI_Jail.class) {
            new Jail().encounter();
        } else if (field.getClass() == GUI_Chance.class) {
            new Chance().encounter();
        } else if (field.getClass() == GUI_Brewery.class) {
            new Jail().encounter();
        } else if (field.getClass() == GUI_Tax.class) {
            new Tax().encounter(gui,player);
        }
    }
}