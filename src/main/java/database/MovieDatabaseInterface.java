package database;

import entity.Entity;

import java.util.List;

public interface MovieDatabaseInterface {
    List<Entity> getAllMovies();
}
