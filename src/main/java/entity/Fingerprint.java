package entity;

import lombok.Value;

import java.util.Map;

@Value
public class Fingerprint {
    Map<Moods, Impact> moods;

    public int compare(Entity e, double balance) {
        int movieRating = e.getRating().getRating();
        Fingerprint f = e.getPrint();
        return f.getMoods().keySet().stream()
                .mapToInt(mood -> scoring(balance, movieRating, mood, f))
                .sum();
    }
    public int compare(Entity e){
        return compare(e, 0);
    }
    public int compare(Fingerprint f){
        return f.getMoods().keySet().stream()
                .mapToInt(mood -> scoring(mood, f))
                .sum();
    }

    @Override
    public String toString() {
        return moods.toString();
    }

    private int scoring(double balance, int movieRating, Moods mood, Fingerprint f){
        return ((int) (balance * (100-movieRating) + mood.compare(this.moods.get(mood), f.moods.get(mood))));
    }
    private int scoring(Moods m, Fingerprint f){
        return m.compare(this.moods.get(m), f.moods.get(m));
    }
}
