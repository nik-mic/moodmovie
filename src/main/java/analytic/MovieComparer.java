package analytic;

import entity.Entity;

@FunctionalInterface
public interface MovieComparer {
    int compareMovie(Entity e);
}
