package analytic;

import entity.Entity;
import entity.Rating;
import lombok.SneakyThrows;
import lombok.Value;

import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public abstract class MovieTopList {
    private List<Entity> ranking;
    private final MovieComparer comparer;
    private final MovieFormatter format;

    public MovieTopList(List<Entity> ranking, MovieComparer com){
        this.ranking = ranking;
        comparer = com;
        format = new StandardFormat();
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

    @SneakyThrows
    public void display(OutputStream out){
        StringBuilder output = new StringBuilder();
        AtomicInteger index = new AtomicInteger(1);
        ranking.forEach(movie -> output.append(index.getAndAdd(1)).append(". ").append(format.format(movie)));
        out.write(output.toString().getBytes(Charset.defaultCharset()));
    }
}
