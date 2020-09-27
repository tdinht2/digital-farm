package Testing;

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

}
