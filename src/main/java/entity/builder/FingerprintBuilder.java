package entity.builder;

import entity.Fingerprint;
import entity.Moods;
import entity.builder.Buildable;
import lombok.Builder;

import java.util.HashMap;
import java.util.Map;

@Builder
public class FingerprintBuilder implements Buildable<Fingerprint> {
    int HAPPY;
    int BLOOD;
    int HORROR;
    int ART;
    int COMEDY;
    int ACTION;
    int FANTASY;
    int LOVE;
    int STORY;
    int Experience;

    public Fingerprint generate() {
        Map<Moods, Integer> moods = new HashMap<>();
        moods.put(Moods.BLOOD, BLOOD);
        moods.put(Moods.HAPPY, HAPPY);
        moods.put(Moods.HORROR, HORROR);
        moods.put(Moods.ART, ART);
        moods.put(Moods.ACTION, ACTION);
        moods.put(Moods.FANTASY, FANTASY);
        moods.put(Moods.EXPERIENCE, Experience);
        moods.put(Moods.STORY, STORY);
        moods.put(Moods.LOVE, LOVE);
        return new Fingerprint(moods);
    }
}
