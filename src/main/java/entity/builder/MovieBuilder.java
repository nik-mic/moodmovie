package entity.builder;

import api.APIStarter;

import info.movito.themoviedbapi.model.MovieDb;
import lombok.Builder;
import lombok.Value;
import util.Values;


@Builder
public class MovieBuilder implements Buildable<MovieDb> {
    Integer movieId;

    @Override
    public MovieDb generate() {
        return APIStarter.INSTANCE.getAPI().getMovies().getMovie(movieId, Values.LANGUAGE_SHORT);
    }
}
