package request.filter;

import api.APIStarter;
import entity.Entity;
import info.movito.themoviedbapi.TmdbGenre;
import info.movito.themoviedbapi.model.Genre;
import lombok.Value;

import java.util.List;
import java.util.stream.Collectors;

@Value
public class IsGenreRule implements SearchRule {
    Genre genre;
    public IsGenreRule(Genre genre){
        this.genre = genre;
    }

    @Override
    public List<Entity> search(List<Entity> picks) {
        return picks.stream().filter(s -> s.getContent().getGenres().contains(genre)).collect(Collectors.toList());
    }
}
