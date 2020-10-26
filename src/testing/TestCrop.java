package testing;

import org.junit.Assert;
import org.junit.Test;
import model.Crop;

public class TestCrop {

    @Test
    public void testWater() {
        Crop rice = new Crop(1, Crop.Type.Rice);
        rice.water();
        rice.water();
        Assert.assertEquals(2, rice.getWaterLevel());
    }

    @Test
    public void testWaterDeadPlant() {
        Crop rice = new Crop(0, Crop.Type.Rice);
        rice.water();
        Assert.assertEquals(0, rice.getWaterLevel());
    }

    @Test
    public void testOverwaterring() {
        Crop rice = new Crop(1, Crop.Type.Rice);
        rice.water();
        rice.water();
        rice.water();
        rice.water();
        Assert.assertEquals(0, rice.getStage());
    }

    @Test
    public void testGrow() {
        Crop rice = new Crop(1, Crop.Type.Rice);    //seed
        rice.water();
        rice.water();
        rice.grow();
        Assert.assertEquals(2, rice.getStage());
        rice.grow();
        Assert.assertEquals(3, rice.getStage());
    }

    @Test
    public void testGrowAlreadyMaturePlant() {
        Crop rice = new Crop(3, Crop.Type.Rice);
        rice.water();
        rice.grow();
        Assert.assertEquals(3, rice.getStage());
        Assert.assertEquals(0, rice.getWaterLevel());
    }
}
