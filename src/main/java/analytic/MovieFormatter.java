package analytic;

import entity.Entity;

@FunctionalInterface
public interface MovieFormatter {
    String format(Entity e);
}
