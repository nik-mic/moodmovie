package analytic;

import entity.Entity;
import entity.Moods;
import entity.builder.FingerprintBuilder;
import info.movito.themoviedbapi.model.people.Person;
import org.apache.commons.lang3.tuple.ImmutablePair;
import util.Values;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public ImmutablePair<Person, Long> getMostRelevantPerson(MovieTopList movies){
        return getMostRelevantPersons(movies).get(0);
    }
    public List<ImmutablePair<Person, Long>> getPersonsPicks(MovieTopList movies){
        List<ImmutablePair<Person, Long>> prepare = getMostRelevantPersons(movies);
        return prepare.subList(0, Math.min(prepare.size(), Values.NUMBER_OF_PICKS));
    }

    private List<ImmutablePair<Person,Long>> getMostRelevantPersons(MovieTopList movies){
        final List<Person> test = movies.getRanking().stream()
                .map(m -> m.getContent().getCredits().getAll())
                .flatMap(Collection::stream).collect(Collectors.toList());

        final Stream<ImmutablePair<Person, Long>> target = test.stream()
                .map(mov -> new ImmutablePair<>(mov, test.stream()
                        .filter(s -> s.equals(mov))
                        .count()))
                .distinct();

        return target
                .sorted(Comparator.comparingLong(s -> -s.right))
                .collect(Collectors.toList());
    }
}
