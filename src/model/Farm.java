package model;
import java.util.Random;

public class Farm {
    private static Random rand = new Random();
    public enum RandomEvent {
        Nothing("Nothing", 80.0),
        Rain("Rain", 30.0),
        Locust("Locust", 10.0),
        Drought("Drought", 10.0);

        private String name;
        private double baseChance;

        /**
         * constructor for the enum
         * @param name string representing the name of the random event
         */
        RandomEvent(String name, double baseChance) {
            this.name = name;
            this.baseChance = baseChance;
        }

        public String getName() { return this.name; }

        public double getChance() { return this.baseChance; }
    }

    private int difficulty; //1 is easy, 2 medium, 3 hard
    private int day;
    private Crop[] cropArray = new Crop[10];

    /**
     * Full constructor for creating a Farm object
     * @param difficulty difficulty for player to play on
     * @param day the initial day to use
     */
    public Farm(int difficulty, int day) {
        this.difficulty = difficulty;
        this.day = day;
    }

    /**
     * Full constructor for creating a Farm object
     * @param difficulty difficulty for player to play on
     */
    public Farm(int difficulty) {
        this(difficulty, 1);
    }

    /**
     * default constructor for a Farm object
     */
    public Farm() {
        this(1);
    }

    /**
     * getter for difficulty
     * @return the difficulty of the farm as an integer
     */
    public int getDifficulty() {
        return this.difficulty;
    }

    /**
     * sets the new difficulty
     * @param difficulty the new difficulty
     */
    public void setDifficulty(int difficulty) {
        if (difficulty >= 1 && difficulty <= 3) {
            this.difficulty = difficulty;
        }
    }

    public Crop[] getCropArray() {
        return this.cropArray;
    }

    public boolean plant(Crop c, int n) {
        if (n > 0) {
            for (int i = 0; i < this.cropArray.length; i++) {
                if (cropArray[i] == null) {
                    cropArray[i] = c;
                    return true;
                }
            }
        }
        return false;
    }

    public void setCropArray(Crop c, int i) {
        this.cropArray[i] = c;
    }
    /**
     * getter for the day
     * @return the current day
     */
    public int getDay() {
        return this.day;
    }

    /**
     * sets the day
     * @param day new day
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * increments the day and returns the new day
     * @return the new day
     */
    public int nextDay() {
        this.day += 1;
        RandomEvent event = this.getRandomEvent();
        if (event.getName().equals("Rain")) {
            rain();
        } else if (event.getName().equals("Drought")) {
            drought();
        } else if (event.getName().equals("Locust")) {
            locust();
        }

        growAllCrops();
        return this.day;
    }

    /**
     * returns a random event using weights and current difficulty
     * @return random event
     */
    private RandomEvent getRandomEvent() {
        double totalWeight = 0.0;
        for (RandomEvent event : RandomEvent.values()) {
            totalWeight += event.getChance() + this.difficulty * 10;
        }

        RandomEvent randomEvent = RandomEvent.Nothing;
        double random = Math.random() * totalWeight;
        for (RandomEvent event : RandomEvent.values()) {
            random -= event.getChance() + this.difficulty * 10;
            if (random <= 0.0) {
                randomEvent = event;
                break;
            }
        }
        return randomEvent;
    }

    private void rain() {
        for (int i = 0; i < this.cropArray.length; i++) {
            if (this.cropArray[i] != null) {
                int rainCount = rand.nextInt(3) + 1;
                    this.cropArray[i].water();
            }
        }
    }

    private void drought() {
        for (int i = 0; i < this.cropArray.length; i++) {
            if (this.cropArray[i] != null) {
                this.cropArray[i].setWaterLevel(this.cropArray[i].getWaterLevel() - rand.nextInt(3) + 1);
            }
        }
    }

    private void locust() {
        for (int i = 0; i < this.cropArray.length; i++) {
            if (this.cropArray[i] != null) {
                //chance of each crop dying increases with higher difficulty
                int deathChance = rand.nextInt(3) + 1 - difficulty;
                if (!this.cropArray[i].isPesticides()) {
                    if (deathChance <= 0) {
                        this.cropArray[i].setStage(0);
                    }
                }
            }
        }
    }

    private void growAllCrops() {
        for (int i = 0; i < this.cropArray.length; i++) {
            if (this.cropArray[i] != null) {
                this.cropArray[i].grow();
            }
        }
    }
}