package entity;

import javafx.util.Builder;

public enum Moods {
    BLOOD, HORROR, HAPPY, ACTION, ART, EXPERIENCE, STORY, LOVE, COMEDY, FANTASY;

    public int compare(Impact own, Impact other){
        System.out.println(own.getWEIGHT());
        return own.getWEIGHT()*(Math.abs(own.getGOAL()-other.getGOAL()));
    }
}
