package entity;

public enum Moods {
    BLOOD, HORROR, HAPPY;

    int compare(Integer ownValue, Integer requestValue) {
        return Math.abs(ownValue - requestValue);
    }
}
