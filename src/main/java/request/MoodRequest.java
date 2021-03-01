package request;

import entity.Entity;
import entity.Fingerprint;
import lombok.Value;
import request.filter.SearchRule;

import java.util.List;


@Value
public class MoodRequest {
    Fingerprint fingerprint;
    SearchRule extraRule;


    public List<Entity> applyExtraRule(List<Entity> picks){
        return extraRule.search(picks);
    }

    public int compare(Fingerprint print) {
        return print.compare(fingerprint);
    }
}
