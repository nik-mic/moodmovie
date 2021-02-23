package request;

import com.google.common.collect.Lists;
import database.MovieDatabaseInterface;
import entity.Entity;
import lombok.Value;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Value
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
        return request.compare(movie.getPrint());
    }

    public Optional<Entity> getTopPick(){
        final List<Entity> topPicks = handleRequest();
        return topPicks.isEmpty() ? Optional.empty() : Optional.of(topPicks.get(0));
    }
}
