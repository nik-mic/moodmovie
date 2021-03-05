import analytic.DBRatingList;
import analytic.MovieTopList;
import analytic.YourRatingList;
import com.google.common.collect.Ordering;
import database.MovieDatabaseInterface;
import entity.Entity;
import entity.Fingerprint;
import entity.Rating;
import entity.builder.FingerprintBuilder;
import entity.builder.MovieBuilder;
import org.junit.jupiter.api.Test;
import util.Values;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class TopListTest {

    Fingerprint happyMovie = FingerprintBuilder
            .builder()
            .HAPPY(10)
            .BLOOD(3)
            .HORROR(0)
            .build().generate();

    Fingerprint horrorMovie = FingerprintBuilder
            .builder()
            .HAPPY(0)
            .BLOOD(3)
            .HORROR(10)
            .build().generate();

    Fingerprint brutalMovie = FingerprintBuilder
            .builder()
            .HAPPY(0)
            .BLOOD(10)
            .HORROR(3)
            .build().generate();

    Fingerprint lessHappyMovie = FingerprintBuilder
            .builder()
            .HAPPY(9)
            .BLOOD(3)
            .HORROR(0)
            .build().generate();

    MovieDatabaseInterface m = () -> {
        List<Entity> movies = new ArrayList<>();
        movies.add(new Entity(MovieBuilder.builder().movieId(123).build().generate(), horrorMovie, Rating.builder().rating(10).build()));
        movies.add(new Entity(MovieBuilder.builder().movieId(124).build().generate(), happyMovie, Rating.builder().rating(5).build()));
        movies.add(new Entity(MovieBuilder.builder().movieId(125).build().generate(), brutalMovie, Rating.builder().rating(15).build()));
        movies.add(new Entity(MovieBuilder.builder().movieId(126).build().generate(), lessHappyMovie, Rating.builder().rating(100).build()));
        return movies;
    };

    List<Entity> movies = m.getAllMovies();

    @Test
    public void sortsYourList(){
        MovieTopList your = new YourRatingList(movies);
        Collections.reverse(your.getRanking());
        assertTrue(Ordering
                .natural()
                .isOrdered(your.getRanking().stream()
                        .map(m -> m.getRating().getRating())
                        .collect(Collectors.toList())));
    }
    @Test
    public void sortsUserList(){
        MovieTopList your = new DBRatingList(movies);
        Collections.reverse(your.getRanking());
        assertTrue(Ordering
                .natural()
                .isOrdered(your.getRanking().stream()
                        .map(m -> Values.CONVERT_RATING(m.getContent().getUserRating()))
                        .collect(Collectors.toList())));
    }
}
