package entity;

import lombok.Value;

@Value
public class Impact {
    int WEIGHT;
    int GOAL;

    public Impact(int goal, int weight){
        this.WEIGHT = classify(weight);
        this.GOAL = goal;
    }

    private int classify(int value){
        if(value>0){
            return 2;
        } else if(value<0){
            return 0;
        } return 1;
    }
}
