package entity;

import api.APIStarter;
import info.movito.themoviedbapi.model.Credits;
import info.movito.themoviedbapi.model.Genre;
import info.movito.themoviedbapi.model.MovieDb;
import lombok.Value;

import java.nio.charset.Charset;
import java.util.List;

@Value
public class MovieContent {
    MovieDb movie;
    int movieID;

    public String getReleaseDate() {
        return movie.getReleaseDate();
    }

    public String getTitle() {
        return movie.getTitle();
    }

    public List<Genre> getGenres() {
        return movie.getGenres();
    }

    public boolean isAdult() {
        return movie.isAdult();
    }

    public float getUserRating() {
        return movie.getUserRating();
    }

    @Override
    public String toString(){
        return movie.toString();
    }

    public Credits getCredits(){
        return APIStarter.INSTANCE.getAPI().getMovies().getCredits(movieID);
    }
}
