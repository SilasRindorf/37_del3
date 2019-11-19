package Logic.Tiles;
public abstract class Logic_Fields {
    private String title;
    private String description;
    public Logic_Fields (String title, String description) {
        this.title = title;
        this.description = description;
    }
    public String getTitle(){
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title){this.title = title;}

    public void setDescription(String description){this.description = description;}
}