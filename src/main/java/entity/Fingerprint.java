package entity;

import lombok.Value;

import java.util.HashMap;
import java.util.Map;

@Value
public class Fingerprint {

    Map<Moods, Integer> moods;

    public int compare(Fingerprint f){
        int value = 0;
        for(Moods m : f.getMoods().keySet()){
            value = value + m.compare(this.moods.get(m), f.moods.get(m));
        } return value;
    }
}
