package request;

import entity.Entity;

import java.util.List;
import java.util.stream.Collectors;

public class IsAdultRule implements SearchRule {
    @Override
    public List<Entity> search(List<Entity> picks) {
        return picks.stream().filter(en -> en.getContent().isAdult()).collect(Collectors.toList());
    }
}
