import entity.Entity;
import entity.Rating;
import entity.builder.EntityBuilder;
import entity.builder.FingerprintBuilder;
import entity.builder.MovieBuilder;
import org.junit.Assert;
import org.junit.Test;

public class BuilderTest {

    Entity one = EntityBuilder.builder()
            .RATING(Rating.builder().rating(10).recension("Test").build())
            .FINGERPRINT(FingerprintBuilder.builder().BLOOD(6).HAPPY(1).HORROR(7).ART(10).Experience(8).ACTION(1).STORY(5).LOVE(3).FANTASY(6).COMEDY(5).build().generate())
            .MOVIE(MovieBuilder.builder().movieId(985).build().generate()).build().generate();

    @Test
    public void Entity01(){
       Assert.assertEquals("Eraserhead - 1978-02-03:Rating: 10\n" +
               "Test", one.toString());
    }
}