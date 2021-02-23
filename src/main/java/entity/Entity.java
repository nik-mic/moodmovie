package entity;

import info.movito.themoviedbapi.model.MovieDb;
import lombok.Value;

@Value
public class Entity {
    MovieDb content;
    Fingerprint print;
    Rating rating;
}
