package entity;

import lombok.Value;

@Value
public class Impact {
    int WEIGHT;
    int GOAL;

    public Impact(int GOAL, int WEIGHT){
        this.WEIGHT = classifyWeight(WEIGHT);
        this.GOAL = classifyGoal(GOAL);
    }

    private int classifyGoal(int value){
        if(value>10){
            return 10;
        } else if(value<0){
            return 0;
        } return value;
    }
    private int classifyWeight(int value){
        if(value>0){
            return 2;
        } else if(value<0){
            return 0;
        } return 1;
    }
}
