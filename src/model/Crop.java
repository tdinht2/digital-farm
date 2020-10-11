package model;
import java.util.Random;
public class Crop {
    private static Random rand = new Random();
    public enum Type {
        Potato("Potato", rand.nextInt(15) + 5),
        Rice("Rice", rand.nextInt(15) + 5),
        Corn("Corn", rand.nextInt(15) + 5)
        ;

        private String name;
        private int basePrice;
        private int growTime;//will need to implement at some point
        /**
         * constructor for the enum
         * @param basePrice the base price of the crop
         */
        Type(String name, int basePrice) {
            this.name = name;
            this.basePrice = basePrice;
            this.growTime = 20;
        }

        public String getName() { return this.name; }

        /**
         * getter for the base price of the enum
         * @return base price of the type
         */
        public int getBasePrice() {
            return this.basePrice;
        }

        public int getGrowTime() {
            return this.growTime;
        }
    }
    private int stage;
    private Type species;
    private boolean watered; //need to implement at some point
    private boolean fertilized; //need to implement at some point

    /**
     * public constructor to create a crop object
     * @param stage stage of growth
     * @param species type of crop
     */
    public Crop(int stage, Type species) {
        this.stage = stage;
        this.species = species;
        this.watered = false;
        this.fertilized = false;
    }

    /**
     * Constrctor to set a random stage and price
     * @param species species of crop
     */
    public Crop(Type species) {
        Random rand = new Random();
        this.stage = rand.nextInt(3) + 1;
        this.species = species;

    }

    /**
     * helper function to create a random base price of a good
     * @return basePrice of the good
     */
    private int calculateBasePrice() {
        Random rand = new Random();
        return rand.nextInt(15) + 5;
    }

    /**
     * getter for the base price
     * @return Base price for this crop
     */
    public int getBasePrice() {
        return species.getBasePrice();
    }



    /**
     * getter for stage of growth
     * @return stage of growth
     */
    public int getStage() {
        return stage;
    }

    /**
     * getter for species of crop
     * @return Type of crop
     */
    public Type getSpecies() {
        return species;
    }

    /**
     * setter for species of crop
     * @param species Type of crop
     */
    public void setSpecies(Type species) {
        this.species = species;
    }

    /**
     * setter for stage of growth
     * @param stage int stage of growth
     */
    public void setStage(int stage) {
        if (stage <= 3 && stage > 0) {
            this.stage = stage;
        }
    }

    /**
     * determine if a crop can be harvested
     * @return if the crop can be harvested
     */
    public boolean canHarvest() {
        return this.stage == 3;
    }

    /**
     * getter for grow time of the crop type
     * @return time for each growth stage
     */
    public int getGrowTime() {
        return species.getGrowTime();
    }

    /**
     * advance the stage of this crop
     * @return if the crop successfully grew a stage
     */
    public boolean grow() {
        if (stage < 3) {
            stage++;
            return true;
        }
        return false;
    }

    /**
     * water this crop
     */
    public void water() {
        this.watered = true;
    }

    /**
     * fertilize this crop
     */
    public void fertilize() {
        this.fertilized = true;
    }

    /**
     * getter for watered attribute
     * @return if crop is watered
     */
    public boolean isWatered() {
        return this.watered;
    }

    /**
     * getter for fertlize attribute
     * @return if crop is fertlized
     */
    public boolean isFertilized() {
        return this.fertilized;
    }

    @Override
    public int hashCode(){
        return 7 * this.getBasePrice() * this.stage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Crop newO = (Crop)o;
        return this.species == newO.getSpecies() && this.stage == newO.getStage() &&
                this.watered == newO.isWatered() && this.fertilized == newO.isFertilized();
    }
}