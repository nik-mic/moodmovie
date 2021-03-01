package entity;

public enum Moods {
    BLOOD, HORROR, HAPPY, ACTION, ART, EXPERIENCE, STORY, LOVE, COMEDY, FANTASY;

    public int compare(Impact own, Impact other){
        return own.getWEIGHT()*other.getWEIGHT()*(Math.abs(own.getGOAL()-other.getGOAL()));
    }
}
