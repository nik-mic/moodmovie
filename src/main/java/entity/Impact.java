package entity;

public class Impact {
    private final int WEIGHT;
    private final int GOAL;

    public Impact(int goal, int weight){
        this.WEIGHT = classify(weight);
        this.GOAL = goal;
    }

    private int classify(int value){
        if(value>0){
            return 2;
        } else if(value<0){
            return 0;
        }
        return 1;
    }

    public int getWEIGHT() {
        return WEIGHT;
    }

    public int getGOAL(){
        return GOAL;
    }
}
