import api.APIStarter;
import database.MovieDatabaseInterface;
import entity.Entity;
import entity.Fingerprint;
import entity.Rating;
import entity.builder.FingerprintBuilder;
import entity.Moods;
import entity.builder.MovieBuilder;
import info.movito.themoviedbapi.model.Genre;
import org.junit.jupiter.api.Test;
import request.filter.IsAdultRule;
import request.MoodRequest;
import request.RequestCalculator;
import request.filter.IsGenreRule;
import util.Values;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class RequestTest {
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

    MoodRequest basicRequestOfHappyMovie= new MoodRequest(happyMovie, s -> s);

    MovieDatabaseInterface m = () -> {
        List<Entity> movies = new ArrayList<>();
        movies.add(new Entity(MovieBuilder.builder().movieId(123).build().generate(), horrorMovie, Rating.builder().rating(1).build()));
        movies.add(new Entity(MovieBuilder.builder().movieId(124).build().generate(), happyMovie, Rating.builder().rating(2).build()));
        movies.add(new Entity(MovieBuilder.builder().movieId(125).build().generate(), brutalMovie, Rating.builder().rating(3).build()));
        movies.add(new Entity(MovieBuilder.builder().movieId(126).build().generate(), lessHappyMovie, Rating.builder().rating(4).build()));
        return movies;
    };


    @Test
    public void RequestHasFingerprint(){
        assertNotNull(basicRequestOfHappyMovie.getFingerprint());
    }
    @Test
    public void RequestHasExtraRule(){
        assertNotNull(basicRequestOfHappyMovie.getExtraRule());
    }

    @Test
    public void findsHappyMovie(){
        RequestCalculator rc = RequestCalculator.builder()
                .DB(m)
                .request(basicRequestOfHappyMovie)
                .build();

        assertEquals(Optional.of(happyMovie), rc.getTopPick().map(Entity::getPrint));
    }

    @Test
    public void appliesExtraRule(){
        MoodRequest requestWithExtraRule = new MoodRequest(happyMovie, s -> s.stream()
                .filter(movie -> movie.getPrint().getMoods().get(Moods.HAPPY).getGOAL()<10)
                .collect(Collectors.toList()));

        RequestCalculator rc = RequestCalculator.builder()
                .DB(m)
                .request(requestWithExtraRule)
                .build();
        assertEquals(Optional.of(lessHappyMovie), rc.getTopPick().map(Entity::getPrint));
    }

    @Test
    public void filterFSK(){
        MoodRequest requestWithExtraRule = new MoodRequest(happyMovie, new IsAdultRule());
        RequestCalculator rc = RequestCalculator.builder()
                .DB(m)
                .request(requestWithExtraRule)
                .build();
        assertFalse(rc.getTopPick().isPresent());
    }

    @Test
    public void filterGenre(){
        Genre g = APIStarter.INSTANCE.getAPI().getMovies().getMovie(123, Values.LANGUAGE_SHORT).getGenres().get(0);
        IsGenreRule rule = new IsGenreRule(g);
        MoodRequest requestWithExtraRule = new MoodRequest(happyMovie, rule);
        RequestCalculator rc = RequestCalculator.builder()
                .DB(m)
                .request(requestWithExtraRule)
                .build();
        assertTrue(rc.getTopPick().isPresent());
    }

    @Test
    public void getCorrectAmountOfSelections(){
        MoodRequest request = new MoodRequest(happyMovie);
        RequestCalculator rc = RequestCalculator.builder()
                .DB(m)
                .request(request)
                .build();
        assertEquals(Math.min(Values.NUMBER_OF_PICKS, m.getAllMovies().size()), rc.getSelection().size());
    }
}
