package model;

public class Farm {
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

    public Crop[] getCropArray() { return this.cropArray;}

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
        growAllCrops();
        return this.day;
    }

    private void growAllCrops() {
        for (int i = 0; i < this.cropArray.length; i++) {
            if (this.cropArray[i] != null) {
                this.cropArray[i].grow();
            }
        }
    }
}
