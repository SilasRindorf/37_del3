package Tiles;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;
import java.awt.*;

public class Street{
    public void encounter(GUI gui, GUI_Street street, GUI_Player player){
        if (street.getOwnerName() == null) {
            if (gui.getUserLeftButtonPressed(" do you want to buy this property", "Yes", "No")) {
                street.setOwnerName(player.getName());
                street.setBorder(player.getPrimaryColor());
                player.setBalance(player.getBalance()-100);
            }
        }
        else {
            System.out.println(street.getSubText());
            //player.setBalance(street.getRent());
        }
    }
}
