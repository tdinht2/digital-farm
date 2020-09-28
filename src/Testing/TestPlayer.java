package Testing;

import main.Farm;
import org.junit.Assert;
import org.junit.Test;
import main.Player;

public class TestPlayer {

    @Test //Saagar
    public void testDefaultConstructorSetMoney() {
        Player player1 = new Player();
        Assert.assertEquals(player1.getMoney(), 1500);
    }

    @Test //Saagar
    public void testInvalidDiffDefault() {
        Player player1 = new Player("player", 0, 4);
        Assert.assertEquals(player1.getMoney(), 1500);

    }

    @Test //Robert
    public void testFarmDay() {
        Farm farm1 = new Farm(1, 1);
        farm1.nextDay();
        Assert.assertEquals(farm1.getDay(), 2);
    }

    @Test //Robert
    public void testFarmSetDifficulty() {
        Farm farm1 = new Farm(1, 1);
        farm1.setDifficulty(3);
        Assert.assertEquals(farm1.getDifficulty(), 3);
    }
}
