import database.MovieDatabaseInterface;
import database.local.LocalDatabase;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LocalDataBaseTest {
    MovieDatabaseInterface m = new LocalDatabase();

    @Test
    public void localHasMovies(){
        Assert.assertTrue(m.getAllMovies().size()>0);
    }

    @Test
    public void localHasMoreThan40Movies(){
        Assert.assertEquals(40, m.getAllMovies().size());
    }

    @Test
    public void localOnlyHasUniqueMovies(){
        List <String> names = new ArrayList<>();
        m.getAllMovies().forEach(movie -> names.add(movie.getContent().toString()));
        Assert.assertTrue(onlyUniqueValues(names));
    }

    private boolean onlyUniqueValues(List<String> list){
        List<String> s = new ArrayList<>();
        for(String part : list){
            if(s.contains(part)){
                return false;
            } s.add(part);
        } return true;
    }
}
