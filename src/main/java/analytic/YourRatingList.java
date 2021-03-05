package analytic;

import entity.Entity;
import util.Values;

import java.util.Collection;
import java.util.List;

public class YourRatingList extends MovieTopList {
    public YourRatingList(List <Entity> movies) {
        super(movies, e -> Values.MAX_RATING - e.getRating().getRating());
    }
}
