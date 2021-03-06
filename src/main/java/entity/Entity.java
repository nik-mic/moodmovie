package entity;

import info.movito.themoviedbapi.model.MovieDb;
import lombok.Value;

@Value
public class Entity {
    MovieContent content;
    Fingerprint print;
    Rating rating;

    @Override
    public String toString(){
        return content.toString() + ":" + rating.toString();
    }
}
