package Entities;
//No asso
public class Entity_Player {
    private String name = "";
    private int balance = 1000;
    private int id;
    private boolean inJail;

    public Entity_Player(int id){
        this.id = id;
        name += id;

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

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }

    public boolean isInJail() {
        return inJail;
    }
}
