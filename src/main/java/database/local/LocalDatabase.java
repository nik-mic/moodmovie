package database.local;

import database.MovieDatabaseInterface;
import entity.Entity;
import entity.Rating;
import entity.builder.EntityBuilder;
import entity.builder.FingerprintBuilder;
import entity.builder.MovieBuilder;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Value
public class LocalDatabase implements MovieDatabaseInterface {
    static List<Entity> entities;
    @Override
    public List<Entity> getAllMovies() {
        load();
        return entities;
    }
    private static void load(){
        entities = new ArrayList<>();
        entities.add(EntityBuilder.builder()
                .RATING(Rating.builder().rating(99).recension("a masterpiece").build())
                .FINGERPRINT(FingerprintBuilder.builder()
                        .BLOOD(1)
                        .HAPPY(3)
                        .HORROR(6)
                        .ACTION(1)
                        .ART(10)
                        .LOVE(0)
                        .COMEDY(2)
                        .FANTASY(8)
                        .EXPERIENCE(10)
                        .STORY(7)
                        .build().generate())
                .MOVIE(MovieBuilder.builder().movieId(62).build().generate()).build().generate());

        entities.add(EntityBuilder.builder()
                .RATING(Rating.builder().rating(97).recension("Machines are coming").build())
                .FINGERPRINT(FingerprintBuilder.builder()
                        .BLOOD(4)
                        .HAPPY(6)
                        .HORROR(7)
                        .ACTION(5)
                        .ART(7)
                        .LOVE(8)
                        .COMEDY(5)
                        .FANTASY(7)
                        .EXPERIENCE(7)
                        .STORY(8)
                        .build().generate())
                .MOVIE(MovieBuilder.builder().movieId(264660).build().generate()).build().generate());
        entities.add(EntityBuilder.builder()
                .RATING(Rating.builder().rating(96).recension("Asian stuff").build())
                .FINGERPRINT(FingerprintBuilder.builder()
                        .BLOOD(5)
                        .HAPPY(5)
                        .HORROR(8)
                        .ACTION(3)
                        .ART(9)
                        .LOVE(4)
                        .COMEDY(7)
                        .FANTASY(1)
                        .EXPERIENCE(8)
                        .STORY(7)
                        .build().generate())
                .MOVIE(MovieBuilder.builder().movieId(496243).build().generate()).build().generate());

        entities.add(EntityBuilder.builder()
                .RATING(Rating.builder().rating(95).recension("inversive Horror").build())
                .FINGERPRINT(FingerprintBuilder.builder()
                        .BLOOD(3)
                        .HAPPY(1)
                        .HORROR(9)
                        .ACTION(0)
                        .ART(9)
                        .LOVE(7)
                        .COMEDY(3)
                        .FANTASY(3)
                        .EXPERIENCE(9)
                        .STORY(6)
                        .build().generate())
                .MOVIE(MovieBuilder.builder().movieId(500840).build().generate()).build().generate());

        entities.add(EntityBuilder.builder()
                .RATING(Rating.builder().rating(95).recension("truly scary").build())
                .FINGERPRINT(FingerprintBuilder.builder()
                        .BLOOD(7)
                        .HAPPY(1)
                        .HORROR(10)
                        .ACTION(3)
                        .ART(8)
                        .LOVE(0)
                        .COMEDY(1)
                        .FANTASY(0)
                        .EXPERIENCE(10)
                        .STORY(6)
                        .build().generate())
                .MOVIE(MovieBuilder.builder().movieId(493922).build().generate()).build().generate());
        entities.add(EntityBuilder.builder()
                .RATING(Rating.builder().rating(94).recension("dreamy zombies").build())
                .FINGERPRINT(FingerprintBuilder.builder()
                        .BLOOD(7)
                        .HAPPY(6)
                        .HORROR(7)
                        .ACTION(7)
                        .ART(7)
                        .LOVE(5)
                        .COMEDY(3)
                        .FANTASY(2)
                        .EXPERIENCE(8)
                        .STORY(5)
                        .build().generate())
                .MOVIE(MovieBuilder.builder().movieId(170).build().generate()).build().generate());

        entities.add(EntityBuilder.builder()
                .RATING(Rating.builder().rating(96).recension("comic made right").build())
                .FINGERPRINT(FingerprintBuilder.builder()
                        .BLOOD(0)
                        .HAPPY(7)
                        .HORROR(0)
                        .ACTION(8)
                        .ART(6)
                        .LOVE(9)
                        .COMEDY(9)
                        .FANTASY(6)
                        .EXPERIENCE(5)
                        .STORY(7)
                        .build().generate())
                .MOVIE(MovieBuilder.builder().movieId(22538).build().generate()).build().generate());
    }
}
