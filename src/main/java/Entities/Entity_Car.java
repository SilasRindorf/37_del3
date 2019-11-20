package Entities;
import java.awt.*;
import java.util.Random;
public class Entity_Car {
    private Color mainColor;
    private Color secondaryColor;
    private int position = 0;
    public Entity_Car(){
        Random rand = new Random();
        mainColor = new Color(rand.nextInt()*255,rand.nextInt()*255 , rand.nextInt()*255);
        secondaryColor = new Color(rand.nextInt()*255,rand.nextInt()*255 , rand.nextInt()*255);
    }
    public Entity_Car(Color mainColor, Color secondaryColor){
        Random rand = new Random();
        this.mainColor = mainColor;
        this.secondaryColor = secondaryColor;
    }

    public Color getMainColor() {
        return mainColor;
    }
    public Color getSecondaryColor(){
        return secondaryColor;
    }

}
