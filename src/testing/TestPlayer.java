package testing;

import model.Market;
import model.Player;
import org.junit.Assert;
import org.junit.Test;
import model.Farm;
import model.Crop;
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
<<<<<<< HEAD
/*
    @Test //Alec
    public void testFullConstructor() {
        HashMap<Object, Integer> inv = new HashMap<>();
        Player player = new Player("Player", 200, inv, 10, 2);
        Assert.assertEquals(player.getName(), "Player");
        Assert.assertEquals(player.getMoney(), 1200);
        Assert.assertEquals(player.getInventory(), new HashMap<Object, Integer>());
        Assert.assertEquals(player.getMaxInventorySpace(), 10);
    }
||||||| 549db80

    @Test //Alec
    public void testFullConstructor() {
        HashMap<Object, Integer> inv = new HashMap<>();
        Player player = new Player("Player", 200, inv, 10, 2);
        Assert.assertEquals(player.getName(), "Player");
        Assert.assertEquals(player.getMoney(), 1200);
        Assert.assertEquals(player.getInventory(), new HashMap<Object, Integer>());
        Assert.assertEquals(player.getMaxInventorySpace(), 10);
    }
=======

//    @Test //Alec
//    public void testFullConstructor() {
//        HashMap<Object, Integer> inv = new HashMap<>();
//        Player player = new Player("Player", 200, inv, 10, 2);
//        Assert.assertEquals(player.getName(), "Player");
//        Assert.assertEquals(player.getMoney(), 1200);
//        Assert.assertEquals(player.getInventory(), new HashMap<Object, Integer>());
//        Assert.assertEquals(player.getMaxInventorySpace(), 10);
//    }
>>>>>>> 8032417e3211661c49807da8cb302d2438f0ee2c

//    @Test //Alec
//    public void testAddItem() {
//        HashMap<Object, Integer> inv = new HashMap<>();
//        Object o = new Object();
//        Player player = new Player("Player", 0, inv, 10, 1);
//        player.getInventory().put(o, 0);
//        player.addItem(o, 3);
//        Assert.assertEquals((int) player.getInventory().get(o), 3);
//    }

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

    @Test //Tien
    public void testFarmConstructor() {
        Farm farm = new Farm(3, 2);
        Assert.assertEquals(farm.getDifficulty(), 3);
        Assert.assertEquals(farm.getDay(), 2);
    }

//    @Test //Tien
//    public void testSubtractItem() {
//        HashMap<Object, Integer> inv = new HashMap<>();
//        Object test = new Object();
//        Player player = new Player("Tien", 0, inv, 10, 2);
//        player.getInventory().put(test, 4);
//        player.subtractItem(test, 5);
//        Assert.assertEquals((int) player.getInventory().get(test), 0);
//    }

    @Test // Alec
    public void testInventoryCount() {
        Player player = new Player("Player", 0, 99999,
                1, new Market(1));
        player.addItem(new Object(), 27);
        player.addItem(new Object(), 78);
        player.addItem(new Object(), 54);
        Assert.assertEquals(159, player.getInventoryCount());
    }

    @Test //Alec
    public void testInventoryCountCrops() {
        Player player = new Player("Player", 0, 99999,
                1, new Market(1));
        player.addItem(Crop.Type.Potato, 62);
        player.addItem(Crop.Type.Potato, 21);
        player.addItem(Crop.Type.Rice, 8);
        player.addItem(Crop.Type.Rice, 10);
        player.addItem(Crop.Type.Corn, 9);
        player.addItem(Crop.Type.Corn, 20);
        Assert.assertEquals(130, player.getInventoryCount());
    }

 */
}
