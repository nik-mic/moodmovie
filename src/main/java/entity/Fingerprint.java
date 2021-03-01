package entity;

import lombok.Value;
import java.util.Map;

@Value
public class Fingerprint {

    Map<Moods, Impact> moods;

    public int compare(Fingerprint f){
        return f.getMoods().keySet().stream()
                .mapToInt(mood -> mood.compare(this.moods.get(mood), f.moods.get(mood)))
                .sum();
    }

    @Override
    public String toString(){
        return moods.toString();
    }
}
