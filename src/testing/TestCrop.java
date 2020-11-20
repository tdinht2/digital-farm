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
        Crop rice = new Crop(7, Crop.Type.Rice);
        rice.water();
        rice.grow();
        Assert.assertEquals(7, rice.getStage());
        Assert.assertEquals(0, rice.getWaterLevel());
    }

    @Test
    public void testAddPesticide() {
        Crop rice = new Crop(3, Crop.Type.Rice);
        rice.addPesticide();
        Assert.assertEquals(true, rice.isPesticides());
    }

    @Test
    public void testAddPesticideDeadCrop() {
        Crop rice = new Crop(0, Crop.Type.Rice);
        rice.addPesticide();
        Assert.assertEquals(false, rice.isPesticides());
    }

    @Test
    public void testFertilize() {
        Crop rice = new Crop(1, Crop.Type.Rice);
        rice.fertilize();
        Assert.assertEquals(true, rice.isFertilized());
        Assert.assertEquals(1, rice.getFertLevel());
    }

    @Test
    public void testFertilizeMaxLevel() {
        Crop rice = new Crop(1, Crop.Type.Rice);
        rice.fertilize(); //1
        rice.fertilize(); //2
        rice.fertilize(); //3
        rice.fertilize();
        rice.fertilize();
        Assert.assertEquals(3, rice.getFertLevel());
    }

    @Test
    public void testFertilizedGrow() {
        Crop rice = new Crop(1, Crop.Type.Rice);
        for (int i = 0; i < 3; i++) {   //water and fertilize 3 times
            rice.fertilize();
            rice.water();
        }

        rice.grow();
        Assert.assertEquals(3, rice.getStage());
        Assert.assertEquals(2, rice.getFertLevel());

        rice.grow();
        Assert.assertEquals(5, rice.getStage());
        Assert.assertEquals(1, rice.getFertLevel());

        rice.grow();
        Assert.assertEquals(7, rice.getStage());
        Assert.assertEquals(0, rice.getFertLevel());
    }

    @Test
    public void testFertOvergrow() {
        Crop rice = new Crop(6, Crop.Type.Rice);
        rice.fertilize();
        rice.water();
        rice.grow();
        Assert.assertEquals(7, rice.getStage());
    }
}
