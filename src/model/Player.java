package model;

import java.util.HashMap;
import java.util.Random;

public class Player {
    private Random rand;
    private String name;
    private int money;
    //will probably initialize with each item having a value of 0
    private HashMap<Object, Integer> inventory;
    private int maxInventorySpace;
    private Farm farm;
    private Market market;
    private int maxHarvest;
    private int dailyHarvest;
    private int maxWater;
    private int dailyWater;

    /**
     * Full constructor to create a new main.Player
     * @param n String representing the player's name
     * @param m int representing the player's money in addition to initial money (handicap)
     * @param space int representing the player's maximum inventory space
     * @param difficulty the difficulty of the farm
     * @param market the market object the player can buy and sell at
     */
    public Player(String n, int m, int space, int difficulty, Market market) {
        name = n;
        money = setMoneyOnDifficulty(difficulty) + m;
        inventory = new HashMap<Object, Integer>();
        maxInventorySpace = space;
        farm = new Farm(difficulty);
        this.market = market;
        this.maxHarvest = 3;
        this.maxWater = 7;
        this.dailyHarvest = 0;
        this.dailyWater = 0;
    }

    public Player(String n, int m, int difficulty) {
        this(n, m, 20, difficulty, new Market(difficulty));
    }

    public Player(String n, int m) {
        this(n, m, 20, 1, new Market(1));
    }

    /**
     * Default constructor to create a new main.Player
     */
    public Player() {
        this("Player", 0, 20, 1, new Market(1));
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
    public void setInventory(HashMap<Object, Integer> i) {
        inventory = i;
    }

    /**
     * Getter for the main.Player's inventory
     * @return ArrayList representing the player's inventory
     */
    public HashMap<Object, Integer> getInventory() {
        return inventory;
    }

    /**
     * Adds a number of a specific item to the main.Player's inventory
     * @param o Object representing an item to be added
     * @param n int representing the number of the item to be added
     * @return boolean depending on whether the item was successfully added
     */
    public boolean addItem(Object o, int n) {
        if (getInventoryCount() + n <= maxInventorySpace) {
            if (inventory.containsKey(o)) {
                inventory.put(o, inventory.get(o) + n);
            } else {
                inventory.put(o, n);
            }
            return true;
        }
        return false;
    }

    /**
     * Removes a number of an item from the main.Player's inventory
     * @param o Object representing an item to be removed
     * @param n int representing the number of the item to remove
     */
    public void subtractItem(Object o, int n) {
        int count = inventory.get(o);
        inventory.put(o, Math.max(count - n, 0));
    }

    public int getInventoryCount() {
        int sum = 0;
        for (Integer n : inventory.values()) {
            sum += n;
        }
        return sum;
    }

    /**
     * getter for the Farm attribute
     * @return the Player's farm
     */
    public Farm getFarm() {
        return this.farm;
    }

    public Market getMarket() {
        return this.market;
    }

    /**
     * harvests a crop and adds it to the player's inventory
     * @param crop crop to harvest
     */
    public boolean harvest(Crop crop) {
        if (dailyHarvest >= maxHarvest) {
            return false;
        }
        if (crop.isFertilized()) {
            if (rand.nextDouble() > .7 && this.getMaxInventorySpace()
                    - this.getInventoryCount() > 1) {
                this.addItem(crop, 2);
            } else {
                this.addItem(crop, 1);
            }
        } else {
            this.addItem(crop, 1);
        }
        dailyHarvest++;
        return true;

    }

    /**
     * setter for maxharvest
     * @param harvest new max
     */
    public void setMaxHarvest(int harvest) {
        this.maxHarvest = harvest;
    }

    /**
     * getter for max harvest
     * @return max harvest amount
     */
    public int getMaxHarvest() {
        return maxHarvest;
    }

    /**
     * getter for daily harvest
     * @return amount harvested today
     */
    public int getDailyHarvest () {
        return dailyHarvest;
    }

    /**
     * setter for daily harvest
     * @param harvest new daily harvest amount
     */
    public void setDailyHarvest(int harvest) {
        this.dailyHarvest = harvest;
    }

    /**
     * getter for max water amount
     * @return max water per day amount
     */
    public int getMaxWater() {
        return this.maxWater;
    }

    /**
     * setter for max water
     * @param water new max water amount
     */
    public void setMaxWater (int water) {
        this.maxWater = water;
    }

    /**
     * getter for amount watered today
     * @return amount watered today
     */
    public int getDailyWater() {
        return this.dailyWater;
    }

    /**
     * setter for daily water
     * @param water amount watered today
     */
    public void setDailyWater(int water) {
        this.dailyWater = water;
    }
}