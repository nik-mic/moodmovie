import entity.Fingerprint;
import entity.builder.FingerprintBuilder;
import entity.Moods;
import org.junit.Assert;
import org.junit.Test;

public class FingerprintTest {
    FingerprintBuilder builderHappyMovie = FingerprintBuilder
            .builder()
            .HAPPY(10)
            .BLOOD(5)
            .HORROR(1)
            .build();

    FingerprintBuilder builderHorrorMovie = FingerprintBuilder
            .builder()
            .HAPPY(0)
            .BLOOD(10)
            .HORROR(10)
            .build();
    @Test
    public void fingerprintHasValues(){
        Fingerprint f = builderHappyMovie.generate();

        Assert.assertEquals(10, (int)f.getMoods().get(Moods.HAPPY));
    }

    @Test
    public void fingerprintCanBeCompared(){
        Fingerprint own = builderHappyMovie.generate();
        Fingerprint other = builderHappyMovie.generate();

        Assert.assertEquals(0, own.compare(other));
    }

    @Test
    public void fingerPrintCanBeComparedDifferent(){
        Fingerprint own = builderHappyMovie.generate();
        Fingerprint other= builderHorrorMovie.generate();

        Assert.assertEquals(own.compare(other), 24);
    }

    @Test
    public void comparingIsBijektiv(){
        Fingerprint own = builderHappyMovie.generate();
        Fingerprint other= builderHorrorMovie.generate();

        Assert.assertEquals(own.compare(other), other.compare(own));
    }
}
