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
                .BLOOD(5)
                .HAPPY(5)
                .HORROR(5)
                .ACTION(5)
                .ART(5)
                .LOVE(5)
                .COMEDY(5)
                .FANTASY(10)
                .Experience(5)
                .STORY(5)
                .build().generate()
                , s -> s);
        RequestCalculator rc = RequestCalculator.builder().DB(db).request(mr).build();
        System.out.println(rc.getTopPick().get() + ": " + rc.getTopPick().get().getContent().isAdult());
    }
}
