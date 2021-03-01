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
                .BLOOD(10)
                .HAPPY(10)
                .HAPPY_WEIGHT(1)
                .HORROR(0)
                .HORROR_WEIGHT(-1)
                .ACTION(0)
                .ACTION_WEIGHT(-1)
                .ART(5)
                .LOVE(10)
                .COMEDY(1)
                .FANTASY(3)
                .EXPERIENCE(1)
                .EXPERIENCE_WEIGHT(1)
                .STORY(7)
                .build().generate()
                , s -> s, 0.6);
        RequestCalculator rc = RequestCalculator.builder().DB(db).request(mr).build();
        System.out.println(rc.getTopPick().get() + ": " + rc.getTopPick().get().getContent().isAdult());
    }
}
