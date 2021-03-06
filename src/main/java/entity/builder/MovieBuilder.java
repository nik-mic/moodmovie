package entity.builder;

import api.APIStarter;

import entity.MovieContent;
import info.movito.themoviedbapi.model.MovieDb;
import lombok.Builder;
import util.Values;


@Builder
public class MovieBuilder implements Buildable<MovieContent> {
    Integer movieId;

    @Override
    public MovieContent generate() {
        return new MovieContent(APIStarter.INSTANCE
                .getAPI()
                .getMovies()
                .getMovie(movieId, Values.LANGUAGE_SHORT), movieId);
    }
}
