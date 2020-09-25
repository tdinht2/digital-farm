import java.util.ArrayList;

public class Player {
    private String name;
    private int money;
    private ArrayList<Object> inventory;
    private int maxInventorySpace;

    /**
     * Constructor to create a new Player
     * @param n String representing the player's name
     * @param m int representing the player's money
     * @param i ArrayList representing the player's inventory
     * @param space int representing the player's maximum inventory space
     */
    public Player(String n, int m, ArrayList<Object> i, int space) {
        name = n;
        money = m;
        inventory = i;
        maxInventorySpace = space;
    }

    /**
     * Constructor to create a new Player
     * @param n String representing the player's name
     * @param m int representing the player's money
     */
    public Player(String n, int m) {
        this(n, m, new ArrayList<Object>(), 20);
    }

    /**
     * Setter for the Player's name
     * @param n String representing the player's name
     */
    public void setName(String n) {
        name = n;
    }

    /**
     * Getter for the Player's name
     * @return a string representing the player's name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the Player's money
     * @param m int representing the player's money
     */
    public void setMoney(int m) {
        money = m;
    }

    /**
     * Getter for the Player's money
     * @return int representing the player's money
     */
    public int getMoney() {
        return money;
    }

    /**
     * Setter for the Player's maxInventorySpace
     * @param space int representing the Player's max inventory space
     */
    public void setMaxInventorySpace(int space) {
        maxInventorySpace = space;
    }

    /**
     * Getter for the Player's maxInventorySpace
     * @return int representing the Player's max inventory space
     */
    public int getMaxInventorySpace() {
        return maxInventorySpace;
    }

    /**
     * Setter for the Player's inventory
     * @param i ArrayList representing the player's inventory
     */
    public void setInventory(ArrayList<Object> i) {
        inventory = i;
    }

    /**
     * Getter for the Player's inventory
     * @return ArrayList representing the player's inventory
     */
    public ArrayList<Object> getInventory() {
        return inventory;
    }

    /**
     * Adds an item to the Player's inventory
     * @param o Object representing an item to be added
     */
    public void addItem(Object o) {
        // need to account for inventory limit later
        inventory.add(o);
    }

    /**
     * Removes an item from the Player's inventory
     * @param o Object representing an item to be added
     */
    public void removeItem(Object o) {
        inventory.remove(o);
    }
}