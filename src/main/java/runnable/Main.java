package runnable;

import database.MovieDatabaseInterface;
import database.local.LocalDatabase;
import entity.builder.FingerprintBuilder;
import request.MoodRequest;
import request.RequestCalculator;
import util.Values;

public class Main {
    public static void main(String[] args) {
        MovieDatabaseInterface db = new LocalDatabase();
        MoodRequest mr = new MoodRequest(FingerprintBuilder.builder()
                .BLOOD(5)
                .HAPPY(5)
                .HORROR(8)
                .ACTION(3)
                .ART(9)
                .LOVE(4)
                .COMEDY(7)
                .FANTASY(1)
                .EXPERIENCE(8)
                .STORY(7)
                .build().generate()
                , s -> s, Values.STANDARD_BALANCE);
        RequestCalculator rc = RequestCalculator.builder().DB(db).request(mr).build();
        System.out.println(rc.getTopPick().get() + ": " + rc.getTopPick().get().getContent().isAdult());
    }
}
