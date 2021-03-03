package database;

import entity.Entity;
import java.util.List;

@FunctionalInterface
public interface MovieDatabaseInterface {
    List<Entity> getAllMovies();
}
