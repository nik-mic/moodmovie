package util;

public class Values {
   public final static String LANGUAGE_SHORT = "en";
    public static final int NUMBER_OF_PICKS = 3;
    public static final String PATH_TO_API_KEY = "api-key.txt";
    public static final double STANDARD_BALANCE = 0.15;
    public static final int MAX_RATING = 100;
    public static final String PATH_TO_LOCAL_DB = "localDB.json";

    public static int CONVERT_RATING(float userRating){
        return (int)(userRating*10);
    }
}
