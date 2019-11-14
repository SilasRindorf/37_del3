package Entities.Tiles;

import gui_fields.GUI_Player;
import gui_fields.GUI_Shipping;
import gui_main.GUI;

public class Shipping {
    public void encounter(GUI gui, GUI_Shipping shipping, GUI_Player player){
        if (shipping.getOwnerName() == null) {
            if (gui.getUserLeftButtonPressed(" do you want to buy this property", "Yes", "No")) {
                shipping.setOwnerName(player.getName());
                shipping.setBorder(player.getPrimaryColor());
                player.setBalance(player.getBalance()-100);
            }
        }
        else {
            System.out.println(shipping.getSubText());
            //player.setBalance(street.getRent());
        }
    }

}
