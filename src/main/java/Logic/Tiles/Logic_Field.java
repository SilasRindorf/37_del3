package Logic.Tiles;

import java.awt.*;
//Asso Java Color

public abstract class Logic_Field {
    private String title;
    private String subText;
    private String description;
    private Color backGroundColor;
    private int fieldID = 0;

    public Logic_Field(String title, String subText, String description, int fieldID) {
        this.title = title;
        this.subText = subText;
        this.description = description;
        this.fieldID = fieldID;
    }


    public String getDescription() {
        return description;
    }

    public String getSubText() {
        return subText;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSubText(String subText) {
        this.subText = subText;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Color getBackGroundColor() {
        return backGroundColor;
    }

    public void setBackGroundColor(Color backGroundColor) {
        this.backGroundColor = backGroundColor;
    }

    public int getFieldID() {
        return fieldID;
    }

    public void setFieldID(int fieldID) {
        this.fieldID = fieldID;
    }

}
