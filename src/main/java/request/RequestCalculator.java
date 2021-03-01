package request;

import database.MovieDatabaseInterface;
import entity.Entity;
import lombok.Builder;
import lombok.Value;
import util.Values;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Value
@Builder
public class RequestCalculator {
    MoodRequest request;
    MovieDatabaseInterface DB;

    public List<Entity> handleRequest(){
        return request.applyExtraRule(
                DB.getAllMovies()
                .stream()
                .sorted(Comparator.comparing(this::scoreSim))
                .collect(Collectors.toList())
        );
    }

    private Integer scoreSim(Entity movie){
        return request.compare(movie);
    }

    public Optional<Entity> getTopPick(){
        final List<Entity> topPicks = handleRequest();
        return topPicks.isEmpty() ? Optional.empty() : Optional.of(topPicks.get(0));
    }
    public List<Entity> getSelection(){
        List<Entity> rawSelect = new ArrayList<>(Values.NUMBER_OF_PICKS);

        return null;
    }
}
