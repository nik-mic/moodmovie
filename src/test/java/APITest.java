import api.APIStarter;
import info.movito.themoviedbapi.TmdbApi;
import org.junit.Test;


public class APITest {

    TmdbApi api = APIStarter.INSTANCE.getAPI();

    @Test
    public void canConnect(){
        assert api!=null && api.getApiKey()!=null;
    }

    @Test
    public void getMovieInfo(){
        String movieToText = api.getMovies().getMovie(507076, "en").toString();
        assert "Climax - 2018-09-19".equals(movieToText);
    }
}
