package model;
import java.util.Random;
import java.util.HashMap;

public class Market {
    private HashMap<Object, Integer> stock;
    private Random rand = new Random(); //class helper attribute
    private int difficulty; //class helper attribute

    /**
     * public constructor to create a market
     * @param difficulty the difficulty of the current game
     */
    public Market(int difficulty) {
        this.difficulty = difficulty;
        initStock();
    }

    /**
     * instantiate the stock of the market with calculated prices of all crops in the game
     */
    private void initStock() {
        this.stock = new HashMap<Object, Integer>();
        Crop.Type[] crops = Crop.Type.values();
        int variance = rand.nextInt(10);
        Item.MarketItem[] items = Item.MarketItem.values();

        //iterate over all crop types, calculate price, and enter into stock
        for (int i = 0; i < crops.length; i++) {
            stock.put(new Crop(1, crops[i]), calculatePrice(crops[i].getBasePrice(), variance));
            stock.put(new Crop(7, crops[i]), calculatePrice(crops[i].getBasePrice(), variance));
        }
        for (int i = 0; i < items.length; i++) {
            stock.put(new Item(items[i]), calculatePrice(items[i].getBasePrice(), variance));
        }
    }

    /**
     * calcualtes the buy/sell price of a crop
     * @param basePrice the base price of the crop, defined in Crop
     * @param variance an additive number to change the price
     * @return the price of the crop
     */
    private Integer calculatePrice(int basePrice, int variance) {
        return basePrice * (4 - difficulty) + variance;
    }

    /**
     * calculates the selling price of the quanitity of crops given
     * @param crop the crop to sell ( from player inventory)
     * @param quantity the amount to sell
     * @return the total selling price
     */
    public int sell(Crop crop, int quantity) {
        int income = this.stock.get(crop);
        if (crop.getStage() == 7) {
            // make 2 times the buying price for growing the crop
            if (crop.isPesticides()) {
                return (int) (1.5 * income * quantity);
            } else {
                return income * quantity * 2;
            }
        }
        return (int) (income * quantity * 0.5); //only get half for selling back a non mature plant

    }

    /**
     * allows the player to buy an amount of crop
     * @param currMoney current money of the player
     * @param item item to buy (from stock)
     * @param quantity amount of buy
     * @param inventorySpaceLeft current inventory space left of player
     * @return if the purchase is legal
     */
    public boolean buy(int currMoney, Object item, int quantity, int inventorySpaceLeft) {
        if (quantity > inventorySpaceLeft) {
            return false;
        }

        if (!stock.containsKey(item)) {
            return false;
        }
        int totalCost = this.stock.get(item) * quantity;
        if (totalCost > currMoney) {
            return false;
        }
        if (item.equals(new Item(Item.MarketItem.Plot))) { //increase price on every plot purchase
            stock.put(new Item(Item.MarketItem.Plot), stock.get(new Item(Item.MarketItem.Plot)) + 10);
        }
        return true;
    }

    /**
     * getter for stock
     * @return the stock of the market
     */
    public HashMap<Object, Integer> getStock() {
        return this.stock;
    }
}
