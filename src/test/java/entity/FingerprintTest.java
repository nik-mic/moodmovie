package entity;

import entity.builder.FingerprintBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        assertEquals(10, f.getMoods().get(Moods.HAPPY).getGOAL());
    }

    @Test
    public void fingerprintCanBeCompared(){
        Fingerprint own = builderHappyMovie.generate();
        Fingerprint other = builderHappyMovie.generate();

        assertEquals(0, own.compare(other));
    }

    @Test
    public void fingerPrintCanBeComparedDifferent(){
        Fingerprint own = builderHappyMovie.generate();
        Fingerprint other= builderHorrorMovie.generate();

        assertEquals(24, own.compare(other));
    }

    @Test
    public void comparingIsBijective(){
        Fingerprint own = builderHappyMovie.generate();
        Fingerprint other= builderHorrorMovie.generate();

        assertEquals(own.compare(other), other.compare(own));
    }
}
