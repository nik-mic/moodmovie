package entity;

public enum Moods {
    BLOOD, HORROR, HAPPY, ACTION, ART, EXPERIENCE, STORY, LOVE, COMEDY, FANTASY;

    int compare(Integer ownValue, Integer requestValue) {
        return Math.abs(ownValue - requestValue);
    }
}
