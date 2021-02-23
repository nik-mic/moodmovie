package request;

import database.MovieDatabaseInterface;
import entity.Entity;
import lombok.Value;

import java.util.Comparator;
import java.util.List;
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
}
