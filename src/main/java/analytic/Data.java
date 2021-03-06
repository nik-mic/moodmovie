package analytic;

import entity.Entity;
import entity.Moods;
import entity.builder.FingerprintBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public enum Data {
    INSTANCE;

    // TODO REF
    public Map<Moods, Double> getMoodPreference(MovieTopList movieList){
        Map<Moods, Integer> target = FingerprintBuilder.builder().build().generate().getMoods().entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().getGOAL())
                );
        for(Entity e : movieList.getRanking()){
            for(Moods mood : e.getPrint().getMoods().keySet()){
                target.put(
                        mood,
                        target.get(mood) + e.getRating().getRating() * e.getPrint().getMoods().get(mood).getGOAL());
            }
        }
        Double sum = 0.0;
        for(Moods m : target.keySet()){
            sum += target.get(m);
        }
        Map<Moods, Double> finalMap = new HashMap<>();
        for(Moods m : target.keySet()){
            finalMap.put(m, target.get(m)/sum);
        }
        return finalMap;
    }
}
