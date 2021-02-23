package request;

import entity.Entity;
import java.util.List;

@FunctionalInterface
public interface SearchRule {
    List<Entity> search(List<Entity> picks);
}
