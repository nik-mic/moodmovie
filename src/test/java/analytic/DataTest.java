package analytic;

import database.MovieDatabaseInterface;
import database.local.LocalDatabase;
import entity.Entity;
import entity.Fingerprint;
import entity.Moods;
import entity.Rating;
import entity.builder.FingerprintBuilder;
import entity.builder.MovieBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataTest {

    Fingerprint happyMovie = FingerprintBuilder
            .builder()
            .HAPPY(10)
            .BLOOD(0)
            .HORROR(0)
            .build().generate();

    Fingerprint horrorMovie = FingerprintBuilder
            .builder()
            .HAPPY(0)
            .BLOOD(0)
            .HORROR(10)
            .build().generate();

    Fingerprint brutalMovie = FingerprintBuilder
            .builder()
            .HAPPY(0)
            .BLOOD(10)
            .HORROR(0)
            .build().generate();

    Fingerprint lessHappyMovie = FingerprintBuilder
            .builder()
            .HAPPY(10)
            .BLOOD(0)
            .HORROR(0)
            .build().generate();

    MovieDatabaseInterface m = () -> {
        List<Entity> movies = new ArrayList<>();
        movies.add(new Entity(MovieBuilder.builder().movieId(123).build().generate(), horrorMovie, Rating.builder().rating(0).build()));
        movies.add(new Entity(MovieBuilder.builder().movieId(124).build().generate(), happyMovie, Rating.builder().rating(0).build()));
        movies.add(new Entity(MovieBuilder.builder().movieId(125).build().generate(), brutalMovie, Rating.builder().rating(0).build()));
        movies.add(new Entity(MovieBuilder.builder().movieId(126).build().generate(), lessHappyMovie, Rating.builder().rating(50).build()));
        return movies;
    };

    List<Entity> movies = m.getAllMovies();

    @Test
    public void calculatesMoodData(){
        System.out.println(Data.INSTANCE.getMoodPreference(new YourRatingList(movies)));
        assertEquals(1, Data.INSTANCE.getMoodPreference(new YourRatingList(movies)).get(Moods.HAPPY));
    }

    @Test
    public void example(){
        System.out.println(Data.INSTANCE.getMoodPreference(new YourRatingList(new LocalDatabase().getAllMovies())));
    }

}
