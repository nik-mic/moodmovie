package api;

import info.movito.themoviedbapi.TmdbApi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public enum APIStarter {
    INSTANCE;
    private final String APIKEY;

    APIStarter() {
        try (Scanner s = new Scanner(new File("api-key.txt"))){
            APIKEY = s.next();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("api-key.txt was not found.");
        }
    }

    public TmdbApi getAPI() {
        return new TmdbApi(APIKEY);
    }
}
