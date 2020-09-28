package Testing;

import main.Farm;
import org.junit.Assert;
import org.junit.Test;
import main.Player;
import java.util.HashMap;

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

    @Test //Alec
    public void testFullConstructor() {
        HashMap<Object, Integer> inv = new HashMap<>();
        Player player = new Player("Player", 200, inv, 10, 2);
        Assert.assertEquals(player.getName(), "Player");
        Assert.assertEquals(player.getMoney(), 1200);
        Assert.assertEquals(player.getInventory(), new HashMap<Object, Integer>());
        Assert.assertEquals(player.getMaxInventorySpace(), 10);
    }

    @Test //Alec
    public void testAddItem() {
        HashMap<Object, Integer> inv = new HashMap<>();
        Object o = new Object();
        Player player = new Player("Player", 0, inv, 10, 1);
        player.getInventory().put(o, 0);
        player.addItem(o, 3);
        Assert.assertEquals((int) player.getInventory().get(o), 3);
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

    @Test //Austin
    public void testSetName() {
        Player player = new Player();
        player.setName("Austin");
        Assert.assertEquals(player.getName(), "Austin");
    }

    @Test //Austin
    public void testSetMaxInventorySpace() {
        Player player = new Player();
        player.setMaxInventorySpace(9999999);
        Assert.assertEquals(9999999, player.getMaxInventorySpace());
    }
}
