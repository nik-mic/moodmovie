import database.MovieDatabaseInterface;
import entity.Entity;
import entity.Fingerprint;
import entity.builder.FingerprintBuilder;
import entity.Moods;
import org.junit.Assert;
import org.junit.Test;

import request.MoodRequest;
import request.RequestCalculator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        movies.add(new Entity(null, horrorMovie, null));
        movies.add(new Entity(null, happyMovie, null));
        movies.add(new Entity(null, brutalMovie, null));
        movies.add(new Entity(null, lessHappyMovie, null));
        return movies;
    };


    @Test
    public void RequestHasFingerprint(){
        Assert.assertNotNull(basicRequestOfHappyMovie.getFingerprint());
    }
    @Test
    public void RequestHasExtraRule(){
        Assert.assertNotNull(basicRequestOfHappyMovie.getExtraRule());
    }

    @Test
    public void findsHappyMovie(){
        RequestCalculator rc = RequestCalculator.builder()
                .DB(m)
                .request(basicRequestOfHappyMovie)
                .build();

        Assert.assertEquals(happyMovie, rc.getTopPick().get().getPrint());
    }

    @Test
    public void appliesExtraRule(){
        MoodRequest requestWithExtraRule = new MoodRequest(happyMovie, s -> s.stream()
                .filter(movie -> movie.getPrint().getMoods().get(Moods.HAPPY)<10)
                .collect(Collectors.toList()));
        RequestCalculator rc = RequestCalculator.builder()
                .DB(m)
                .request(requestWithExtraRule)
                .build();

        Assert.assertEquals(rc.getTopPick().get().getPrint(), lessHappyMovie);
    }
}
