package Tiles;
import gui_fields.*;
import gui_main.GUI;

public class Tile {
    private GUI gui;

    public Tile(GUI gui){
        this.gui = gui;
    }
    public void determineTile(GUI_Street street){
        boolean buy = gui.getUserLeftButtonPressed(" do you want to buy this property", "Yes", "No");
        //street.encounter(buy);
    }
    public void determineTile(GUI_Brewery brewery){
    }
    public void determineTile(GUI_Chance chance){
    }
    public void determineTile(GUI_Jail jail){
    }
    public void determineTile(GUI_Refuge refuge){
    }
    public void determineTile(GUI_Shipping shipping){
    }
}
