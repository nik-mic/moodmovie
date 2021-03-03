package entity.builder;

import entity.Fingerprint;
import entity.Impact;
import entity.Moods;
import lombok.Builder;

import java.util.HashMap;
import java.util.Map;

@Builder
public class FingerprintBuilder implements Buildable<Fingerprint> {
    int BLOOD_WEIGHT;
    int HAPPY_WEIGHT;
    int HORROR_WEIGHT;
    int ART_WEIGHT;
    int ACTION_WEIGHT;
    int FANTASY_WEIGHT;
    int EXPERIENCE_WEIGHT;
    int STORY_WEIGHT;
    int LOVE_WEIGHT;
    int COMEDY_WEIGHT;
    int HAPPY;
    int BLOOD;
    int HORROR;
    int ART;
    int COMEDY;
    int ACTION;
    int FANTASY;
    int LOVE;
    int STORY;
    int EXPERIENCE;

    public Fingerprint generate() {
        Map<Moods, Impact> moods = new HashMap<>();
        moods.put(Moods.BLOOD, new Impact(BLOOD, BLOOD_WEIGHT));
        moods.put(Moods.HAPPY, new Impact(HAPPY, HAPPY_WEIGHT));
        moods.put(Moods.HORROR, new Impact(HORROR,HORROR_WEIGHT));
        moods.put(Moods.ART, new Impact(ART, ART_WEIGHT));
        moods.put(Moods.ACTION, new Impact(ACTION, ACTION_WEIGHT));
        moods.put(Moods.FANTASY, new Impact(FANTASY, FANTASY_WEIGHT));
        moods.put(Moods.EXPERIENCE, new Impact(EXPERIENCE, EXPERIENCE_WEIGHT));
        moods.put(Moods.STORY, new Impact(STORY, STORY_WEIGHT));
        moods.put(Moods.LOVE, new Impact(LOVE, LOVE_WEIGHT));
        moods.put(Moods.COMEDY, new Impact(COMEDY, COMEDY_WEIGHT));
        return new Fingerprint(moods);
    }
}
