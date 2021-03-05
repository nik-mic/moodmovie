import database.MovieDatabaseInterface;
import entity.Entity;
import entity.Fingerprint;
import entity.Rating;
import entity.builder.FingerprintBuilder;
import entity.builder.MovieBuilder;
import org.junit.jupiter.api.Test;
import request.MoodRequest;
import request.RequestCalculator;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BalanceTest {
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
            .HAPPY(8)
            .BLOOD(3)
            .HORROR(1)
            .build().generate();


    MovieDatabaseInterface m = () -> {
        List<Entity> movies = new ArrayList<>();
        movies.add(new Entity(MovieBuilder.builder().movieId(123).build().generate(), horrorMovie, Rating.builder().rating(20).build()));
        movies.add(new Entity(MovieBuilder.builder().movieId(124).build().generate(), happyMovie, Rating.builder().rating(100).build()));
        movies.add(new Entity(MovieBuilder.builder().movieId(125).build().generate(), brutalMovie, Rating.builder().rating(10).build()));
        movies.add(new Entity(MovieBuilder.builder().movieId(126).build().generate(), lessHappyMovie, Rating.builder().rating(50).build()));
        return movies;
    };



    @Test
    public void usesRatingInCalculation(){
        MoodRequest high = new MoodRequest(FingerprintBuilder.builder()
                .HAPPY(8)
                .BLOOD(3)
                .HORROR(0)
                .build().generate(),
                s->s, 1);
        MoodRequest low = new MoodRequest(FingerprintBuilder.builder()
                .HAPPY(8)
                .BLOOD(3)
                .HORROR(1)
                .build().generate(),
                s->s, 0.001);

        RequestCalculator highRating = RequestCalculator.builder().request(high).DB(m).build();
        RequestCalculator lowRating = RequestCalculator.builder().request(low).DB(m).build();

        assertNotEquals(highRating.getTopPick().get(),lowRating.getTopPick().get());
    }
}
