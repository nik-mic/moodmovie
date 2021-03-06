package entity;

import lombok.NonNull;
import lombok.Value;
import util.Values;

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

    public int compare(Fingerprint f){
        return f.getMoods().keySet().stream()
                .mapToInt(mood -> scoring(mood, f))
                .sum();
    }

    private int scoring(double balance, int movieRating, Moods mood, Fingerprint f){
        return ((int) (balance * (Values.MAX_RATING -movieRating) + mood.compare(this.moods.get(mood), f.moods.get(mood))));
    }

    private int scoring(Moods m, Fingerprint f){
        return m.compare(this.moods.get(m), f.moods.get(m));
    }
    @Override
    public String toString() {
        return moods.toString();
    }
}
