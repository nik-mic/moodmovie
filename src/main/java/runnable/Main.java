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
                .BLOOD(8)
                .HAPPY(8)
                .HORROR(3)
                .ACTION(7)
                .ACTION_WEIGHT(-1)
                .ART(10)
                .ART_WEIGHT(10)
                .LOVE(5)
                .LOVE_WEIGHT(-1)
                .COMEDY(8)
                .FANTASY(6)
                .EXPERIENCE(4)
                .STORY(6)
                .build().generate()
                , s -> s, Values.STANDARD_BALANCE);
        RequestCalculator rc = RequestCalculator.builder().DB(db).request(mr).build();
        System.out.println(rc.getSelection());
    }
}
