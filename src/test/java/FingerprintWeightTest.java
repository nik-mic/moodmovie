import entity.Moods;
import entity.builder.FingerprintBuilder;
import org.junit.Assert;
import org.junit.Test;

public class FingerprintWeightTest {
    FingerprintBuilder stan = FingerprintBuilder.builder().LOVE(5).build();
    FingerprintBuilder high = FingerprintBuilder.builder().LOVE(5).LOVE_WEIGHT(100).build();
    FingerprintBuilder low = FingerprintBuilder.builder().LOVE(5).LOVE_WEIGHT(-69).build();

    @Test
    public void MoodHasStandardWeight(){
        Assert.assertEquals(1, getLoveWeight(stan));
    }

    @Test
    public void MoodHasHigherWeight(){
        Assert.assertEquals(2, getLoveWeight(high));
    }

    @Test
    public void MoodHasLowWeight(){
        Assert.assertEquals(0, getLoveWeight(low));
    }

    private int getLoveWeight(FingerprintBuilder b){
        return b.generate().getMoods().get(Moods.LOVE).getWEIGHT();
    }


}
