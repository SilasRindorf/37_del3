package Entities;
public class Entity_Player {
    private String name = "";
    private int balance = 1000;
    private int id;
    private boolean inJail;
    private boolean chanceOutOfJail;

    public Entity_Player(int id){
        this.id = id;
        name += id;
        inJail = false;
        chanceOutOfJail = false;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public boolean getInJail(){
        return inJail;
    }
    public void setInJail(boolean inJail){
        this.inJail = inJail;
    }
    public boolean getchanceOutOfJail(){
        return chanceOutOfJail;
    }
    public void setchanceOutOfJail(boolean chanceOutOfJail){
        this.chanceOutOfJail = chanceOutOfJail;
    }
}
