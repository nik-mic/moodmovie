package api;

import info.movito.themoviedbapi.TmdbApi;
import lombok.Value;
import util.Values;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public enum APIStarter {
    INSTANCE;

    private final TmdbApi API;
    APIStarter() {
        try (Scanner s = new Scanner(new File(Values.PATH_TO_API_KEY))){
            String APIKEY = s.next();
            API = new TmdbApi(APIKEY);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("api-key.txt was not found.");
        }
    }
    public TmdbApi getAPI() {
        return API;
    }
}
