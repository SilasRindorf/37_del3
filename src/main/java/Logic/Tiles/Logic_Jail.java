package Logic.Tiles;
//todo: move to jail field.
//For Betina
public class Logic_Jail extends Logic_Field {
    private boolean inJail;
    private boolean chanceOutOfJail;


    public Logic_Jail(int id) {
        super("Title", "SubText", "Description", id);
    }

    public boolean getInJail() {
        return inJail;
    }

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }

    public boolean getchanceOutOfJail() {
        return chanceOutOfJail;
    }

    public void setchanceOutOfJail(boolean chanceOutOfJail) {
        this.chanceOutOfJail = chanceOutOfJail;
    }
}