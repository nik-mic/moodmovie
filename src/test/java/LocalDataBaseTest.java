import database.MovieDatabaseInterface;
import database.local.LocalDatabase;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LocalDataBaseTest {
    MovieDatabaseInterface m = new LocalDatabase();

    @Test
    public void localHasMovies(){
        assertTrue(m.getAllMovies().size()>0);
    }

    @Test
    public void localHasMoreThan40Movies(){
        assertEquals(42, m.getAllMovies().size());
    }

    @Test
    public void localOnlyHasUniqueMovies(){
        List <String> names = new ArrayList<>();
        m.getAllMovies().forEach(movie -> names.add(movie.getContent().toString()));
        assertTrue(onlyUniqueValues(names));
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
