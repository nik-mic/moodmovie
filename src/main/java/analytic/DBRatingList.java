package analytic;

import entity.Entity;
import util.Values;

import java.util.List;

public class DBRatingList extends MovieTopList{
    public DBRatingList(List<Entity> movies) {
        super(movies, e -> Values.CONVERT_RATING(Values.MAX_RATING - e.getContent().getUserRating()));
    }
}
