package Entities.Tiles;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;

public class Street{
    public void encounter(GUI gui, GUI_Street street, GUI_Player player){
        if (street.getOwnerName() == null) {
                street.setOwnerName(player.getName());
                street.setBorder(player.getPrimaryColor());
                player.setBalance(player.getBalance()-100);
            }
        else {
            System.out.println(street.getSubText());
            //player.setBalance(street.getRent());
        }
    }
}