package main;

import java.util.ArrayList;

public class Player {
    private String name;
    private int money;
    private ArrayList<Object> inventory;
    private int maxInventorySpace;
    private Farm farm;

    /**
     * Constructor to create a new main.Player
     * @param n String representing the player's name
     * @param m int representing the player's money in addition to initial money (handicap)
     * @param i ArrayList representing the player's inventory
     * @param space int representing the player's maximum inventory space
     * @param difficulty the difficulty of the farm
     */
    public Player(String n, int m, ArrayList<Object> i, int space, int difficulty) {
        name = n;
        money = setMoneyOnDifficulty(difficulty) + m;
        inventory = i;
        maxInventorySpace = space;
        farm = new Farm(difficulty);
    }

    /**
     * Constructor to create a new main.Player
     * @param n String representing the player's name
     * @param m int representing the player's money
     */
    public Player(String n, int m) {
        this(n, m, new ArrayList<Object>(), 20, 1);
    }

    /**
     * Setter for the main.Player's name
     * @param n String representing the player's name
     */
    public void setName(String n) {
        name = n;
    }

    /**
     * Getter for the main.Player's name
     * @return a string representing the player's name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the main.Player's money
     * @param m int representing the player's money
     */
    public void setMoney(int m) {
        money = m;
    }

    /**
     * Getter for the main.Player's money
     * @return int representing the player's money
     */
    public int getMoney() {
        return money;
    }

    /**
     * a private helper method to set the money of the player based on the difficulty
     * @param difficulty the difficulty of the farm
     * @return int the initial money of the player
     */
    private int setMoneyOnDifficulty(int difficulty) {
        if (difficulty == 3) {
            this.money = 500;
        } else if (difficulty == 2) {
            this.money = 1000;
        } else { //defaults to difficulty 1 if not 3 or 2
            this.money = 1500;
        }
        return this.money;
    }
    /**
     * Setter for the main.Player's maxInventorySpace
     * @param space int representing the main.Player's max inventory space
     */
    public void setMaxInventorySpace(int space) {
        maxInventorySpace = space;
    }

    /**
     * Getter for the main.Player's maxInventorySpace
     * @return int representing the main.Player's max inventory space
     */
    public int getMaxInventorySpace() {
        return maxInventorySpace;
    }

    /**
     * Setter for the main.Player's inventory
     * @param i ArrayList representing the player's inventory
     */
    public void setInventory(ArrayList<Object> i) {
        inventory = i;
    }

    /**
     * Getter for the main.Player's inventory
     * @return ArrayList representing the player's inventory
     */
    public ArrayList<Object> getInventory() {
        return inventory;
    }

    /**
     * Adds an item to the main.Player's inventory
     * @param o Object representing an item to be added
     */
    public void addItem(Object o) {
        // need to account for inventory limit later
        inventory.add(o);
    }

    /**
     * Removes an item from the main.Player's inventory
     * @param o Object representing an item to be added
     */
    public void removeItem(Object o) {
        inventory.remove(o);
    }
}