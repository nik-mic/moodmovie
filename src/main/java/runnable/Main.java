package runnable;

import database.MovieDatabaseInterface;
import database.local.LocalDatabase;
import entity.builder.FingerprintBuilder;
import request.MoodRequest;
import request.RequestCalculator;

import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        MovieDatabaseInterface db = new LocalDatabase();
        MoodRequest mr = new MoodRequest(FingerprintBuilder.builder()
                .BLOOD(10)
                .HAPPY(10)
                .HORROR(10)
                .ACTION(10)
                .ART(10)
                .LOVE(10)
                .COMEDY(10)
                .FANTASY(10)
                .Experience(10)
                .STORY(10)
                .build().generate()
                , s -> s.stream().filter(t->t.getRating().getRating()<95).collect(Collectors.toList()));
        RequestCalculator rc = RequestCalculator.builder().DB(db).request(mr).build();
        System.out.println(rc.getTopPick().get());
    }
}
