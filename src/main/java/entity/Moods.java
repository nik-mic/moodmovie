package entity;

import lombok.NonNull;

public enum Moods {
    BLOOD, HORROR, HAPPY, ACTION, ART, EXPERIENCE, STORY, LOVE, COMEDY, FANTASY;

    @NonNull
    public int compare(Impact own, Impact other){
        return (own.getWEIGHT() * other.getWEIGHT()) * (Math.abs(own.getGOAL()-other.getGOAL()));
    }
}
