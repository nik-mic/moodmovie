import api.APIStarter;
import info.movito.themoviedbapi.TmdbApi;
import org.junit.Assert;
import org.junit.Test;


public class APITest {

    TmdbApi api = APIStarter.INSTANCE.getAPI();

    @Test
    public void canConnect(){
        Assert.assertTrue(api!=null && api.getApiKey()!=null);
    }

    @Test
    public void canGetMovieInfo(){
        String movieToText = api.getMovies().getMovie(507076, "en").toString();

        Assert.assertEquals("Climax - 2018-09-19", movieToText);
    }
}
