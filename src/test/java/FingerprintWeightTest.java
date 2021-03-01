import database.MovieDatabaseInterface;
import entity.Entity;
import entity.Fingerprint;
import entity.Moods;
import entity.builder.FingerprintBuilder;
import entity.builder.MovieBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void calculatesWeights(){
        Fingerprint horrorMovie = FingerprintBuilder
                .builder()
                .HAPPY(0)
                .BLOOD(10)
                .HORROR(10)
                .build().generate();

        Fingerprint loveMovie = FingerprintBuilder
                .builder()
                .HAPPY(10)
                .BLOOD(0)
                .HORROR(0)
                .build().generate();

        Fingerprint extremeHorrorMovie = FingerprintBuilder
                .builder()
                .HAPPY(0)
                .BLOOD(10)
                .HORROR(10)
                .HORROR_WEIGHT(100)
                .build().generate();

        Assert.assertTrue(extremeHorrorMovie.compare(loveMovie)>horrorMovie.compare(loveMovie));

    }

    private int getLoveWeight(FingerprintBuilder b){
        return b.generate().getMoods().get(Moods.LOVE).getWEIGHT();
    }




}
