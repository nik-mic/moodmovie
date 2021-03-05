import entity.Entity;
import entity.Rating;
import entity.builder.EntityBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RatingTest {
    final Entity e = EntityBuilder.builder()
            .MOVIE(null)
            .FINGERPRINT(null)
            .RATING(Rating.builder().rating(69).recension("Test").build()).build().generate();

    @Test
    public void EntityHasRating(){
        assertTrue(e.getRating().getRating()==69
                && e.getRating().getRecension().equals("Test"));
    }
}
