package util;

public class Values {
   public final static String LANGUAGE_SHORT = "en";
    public static final int NUMBER_OF_PICKS = 50;
    public static final String PATH_TO_API_KEY = "api-key.txt";
    public static final double STANDARD_BALANCE = 0.21;
    public static final int MAX_RATING = 100;

    public static int CONVERT_RATING(float userRating){
        return (int)(userRating*10);
    }
}
