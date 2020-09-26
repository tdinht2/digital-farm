package main;

public class Farm {
    private int difficulty; //1 is easy, 2 medium, 3 hard
    //will need a Plot object and arraylist of plots when that fucntionality is added
    /**
     * Full constructor for creating a Farm object
     * @param difficulty difficulty for player to play on
     */
    public Farm(int difficulty) {
        this.difficulty = difficulty;
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

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

}
