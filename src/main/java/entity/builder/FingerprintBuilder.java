package entity.builder;

import entity.Fingerprint;
import entity.Moods;
import entity.builder.Buildable;
import lombok.Builder;

import java.util.HashMap;
import java.util.Map;

@Builder
public class FingerprintBuilder implements Buildable<Fingerprint> {
    Integer HAPPY;
    Integer BLOOD;
    Integer HORROR;

    public Fingerprint generate() {
        Map<Moods, Integer> moods = new HashMap<>();
        moods.put(Moods.BLOOD, BLOOD);
        moods.put(Moods.HAPPY, HAPPY);
        moods.put(Moods.HORROR, HORROR);
        return new Fingerprint(moods);
    }
}
