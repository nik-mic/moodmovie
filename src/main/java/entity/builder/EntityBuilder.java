package entity.builder;

import entity.Entity;
import entity.Fingerprint;
import entity.MovieContent;
import entity.Rating;
import info.movito.themoviedbapi.model.MovieDb;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class EntityBuilder implements Buildable<Entity> {
    Rating RATING;
    MovieContent MOVIE;
    Fingerprint FINGERPRINT;
    @Override
    public Entity generate() {
        return new Entity(MOVIE, FINGERPRINT, RATING);
    }
}
