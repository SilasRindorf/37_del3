package Entities.Tiles;
import gui_fields.GUI_Player;
import gui_main.GUI;

public class Tax {
    public void encounter(GUI gui, GUI_Player player) {
        if(gui.getUserLeftButtonPressed("You need to pay tax","Pay 10%","Pay 200 money"))
            player.setBalance(player.getBalance() - (player.getBalance()/10));
        else
            player.setBalance(player.getBalance() - 200);
    }
}