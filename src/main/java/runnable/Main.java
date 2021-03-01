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
                .HAPPY(1)
                .HORROR(4)
                .ACTION(0)
                .ART(10)
                .ACTION_WEIGHT(-100)
                .LOVE(4)
                .COMEDY(0)
                .FANTASY(2)
                .EXPERIENCE(0)
                .EXPERIENCE_WEIGHT(100)
                .STORY(0)
                .build().generate()
                , s -> s);
        RequestCalculator rc = RequestCalculator.builder().DB(db).request(mr).build();
        System.out.println(rc.getTopPick().get() + ": " + rc.getTopPick().get().getContent().isAdult());
    }
}
