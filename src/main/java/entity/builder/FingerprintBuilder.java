package entity.builder;

import entity.Fingerprint;
import entity.Impact;
import entity.Moods;
import lombok.Builder;

import java.util.HashMap;
import java.util.Map;

@Builder
public class FingerprintBuilder implements Buildable<Fingerprint> {
    @Builder.Default
    int BLOOD_WEIGHT = 0;
    @Builder.Default
    int HAPPY_WEIGHT = 0;
    @Builder.Default
    int HORROR_WEIGHT = 0;
    @Builder.Default
    int ART_WEIGHT = 0;
    @Builder.Default
    int ACTION_WEIGHT = 0;
    @Builder.Default
    int FANTASY_WEIGHT = 0;
    @Builder.Default
    int EXPERIENCE_WEIGHT = 0;
    @Builder.Default
    int STORY_WEIGHT = 0;
    @Builder.Default
    int LOVE_WEIGHT = 0;
    @Builder.Default
    int COMEDY_WEIGHT = 0;
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
