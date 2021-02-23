package request;

import database.MovieDatabaseInterface;
import entity.Entity;
import entity.Fingerprint;
import lombok.Value;

import java.util.List;
import java.util.Map;

@Value
public class MoodRequest {
    Fingerprint fingerprint;
    // List<Integer> weights;
    SearchRule extraRule;


    public List<Entity> applyExtraRule(List<Entity> picks){
        return extraRule.search(picks);
    }

    public int compare(Fingerprint print) {
        return print.compare(fingerprint);
    }
}
