package Entities;

public class Entity_Tiles {
    private String title;
    private String subText;
    private String description;
    public Entity_Tiles(String title,String subText,String description){
        this.title = title;
        this.subText = subText;
        this.description = description;
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
}
