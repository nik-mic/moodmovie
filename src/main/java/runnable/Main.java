package runnable;

import database.MovieDatabaseInterface;
import database.local.LocalDatabase;
import entity.builder.FingerprintBuilder;
import request.MoodRequest;
import request.RequestCalculator;

public class Main {
    public static void main(String[] args) {
        MovieDatabaseInterface db = new LocalDatabase();
        MoodRequest mr = new MoodRequest(FingerprintBuilder.builder()
                .BLOOD(0)
                .HAPPY(10)
                .HAPPY_WEIGHT(1)
                .HORROR(0)
                .HORROR_WEIGHT(-1)
                .ACTION(0)
                .ACTION_WEIGHT(-1)
                .ART(0)
                .LOVE(10)
                .COMEDY(10)
                .FANTASY(10)
                .EXPERIENCE(0)
                .EXPERIENCE_WEIGHT(1)
                .STORY(0)
                .build().generate()
                , s -> s, 0.5);
        RequestCalculator rc = RequestCalculator.builder().DB(db).request(mr).build();
        System.out.println(rc.getTopPick().get() + ": " + rc.getTopPick().get().getContent().isAdult());
    }
}
