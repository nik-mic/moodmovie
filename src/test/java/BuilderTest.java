import entity.Entity;
import entity.Rating;
import entity.builder.EntityBuilder;
import entity.builder.FingerprintBuilder;
import entity.builder.MovieBuilder;
import info.movito.themoviedbapi.model.MovieDb;
import org.junit.Assert;
import org.junit.Test;

public class BuilderTest {

    Entity one = EntityBuilder.builder()
            .RATING(Rating.builder().rating(10).recension("Test").build())
            .FINGERPRINT(FingerprintBuilder.builder().BLOOD(10).HAPPY(0).HORROR(5).build().generate())
            .MOVIE(MovieBuilder.builder().movieId(985).build().generate()).build().generate();

    @Test
    public void Entity01(){
       Assert.assertEquals("Eraserhead - 1978-02-03:{HAPPY=0, BLOOD=10, HORROR=5}:Rating: 10\nTest", one.toString());
    }
}
