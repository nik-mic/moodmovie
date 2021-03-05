package analytic;

import entity.Entity;
import entity.Rating;
import lombok.Value;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class MovieTopList {
    private List<Entity> ranking;
    private final MovieComparer comparer;

    public MovieTopList(List<Entity> ranking, MovieComparer com){
        this.ranking = ranking;
        comparer = com;
        orderList();
    }

    void orderList(){
       ranking = ranking.stream()
               .sorted(Comparator.comparing(comparer::compareMovie))
               .collect(Collectors.toList());
    }

    public List<Entity> getRanking() {
        return ranking;
    }
}
