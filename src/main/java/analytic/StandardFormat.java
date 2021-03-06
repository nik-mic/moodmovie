package analytic;

import entity.Entity;
import util.Values;

public class StandardFormat implements MovieFormatter{
    @Override
    public String format(Entity e) {
        String movieTitle = e.getContent().getTitle();
        String release = e.getContent().getReleaseDate().split("-")[0];
        return movieTitle + "(" + release + ") - [" + e.getRating().getRating() + "/" + Values.MAX_RATING + "]\n";
    }
}
