package model;

import java.util.Random;

public class Item {
    private static Random rand = new Random();
    public enum MarketItem {
        Fertilizer("Fertilizer", rand.nextInt(25) + 5),
        Pesticides("Pesticides", rand.nextInt(10) + 5);

        private String name;
        private int basePrice;
        /**
         * constructor for the enum
         * @param basePrice the base price of the crop
         * @param name string representing the name of the crop
         */
        MarketItem(String name, int basePrice) {
            this.name = name;
            this.basePrice = basePrice;
        }

        public String getName() {
            return this.name;
        }

        /**
         * getter for the base price of the enum
         * @return base price of the type
         */
        public int getBasePrice() {
            return this.basePrice;
        }

    }

    private MarketItem item;

    public Item(MarketItem item) {
        this.item = item;
    }

    public int getBasePrice() { return this.item.getBasePrice(); }
    public String getName() { return this.item.getName(); }

    @Override
    public int hashCode() {
        return 7 * this.getBasePrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item newO = (Item) o;
        return this.getBasePrice() == newO.getBasePrice() &&
                this.getName() == newO.getName();
    }


}
