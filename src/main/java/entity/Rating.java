package entity;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Rating {
    int rating;
    String recension;

    @Override
    public String toString(){
        return "Rating: " + rating + "\n" + recension;
    }

}
