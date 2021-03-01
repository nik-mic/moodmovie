package request;

import entity.Entity;
import entity.Fingerprint;
import lombok.Builder;
import lombok.Value;
import request.filter.SearchRule;

import java.util.List;

@Value
public class MoodRequest {
    Fingerprint fingerprint;
    SearchRule extraRule;
    double balance;

    public MoodRequest(Fingerprint f, SearchRule sr){
        this(f, sr, 0);
    }
    public MoodRequest(Fingerprint f, SearchRule sr, double balance){
        this.fingerprint = f;
        this.extraRule = sr;
        this.balance = balance;
    }

    public List<Entity> applyExtraRule(List<Entity> picks){
        return extraRule.search(picks);
    }

    public int compare(Entity movie) {
        return fingerprint.compare(movie, balance);
    }
}
