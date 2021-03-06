package api;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.TmdbPeople;
import org.junit.jupiter.api.Test;
import util.Values;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class APITest {

    TmdbApi api = APIStarter.INSTANCE.getAPI();

    @Test
    public void canConnect(){
        assertTrue(api!=null && api.getApiKey()!=null);
    }

    @Test
    public void canGetMovieInfo(){
        String movieToText = api.getMovies().getMovie(507076, "en").toString();
        assertEquals("Climax - 2018-09-19", movieToText);
    }
}
