package com.bootcamp.spotify.configuration;

import com.bootcamp.spotify.domain.model.Album;
import com.bootcamp.spotify.domain.model.Artist;
import com.bootcamp.spotify.domain.model.Track;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class SpotifyConfiguration {

    @Bean(name = "artists")
    public List<Artist> getArtists(){
        return Arrays.asList(new Artist(1, "Madonna", "Pop", "/url"),
                new Artist(2, "Britney Spears", "Pop", "/url"),
                new Artist(3, "Justin Bieber", "Pop", "/url"),
                new Artist(4, "David Guetta", "Electronica", "/url"),
                new Artist(5, "Arbat", "Electronica", "/url"),
                new Artist(6, "Tale of Us", "Electronica", "/url"));
    }

    @Bean(name = "albums")
    public List<Album> getAlbums(){
        return Arrays.asList(new Album(1, new Artist(1, "Madonna", "Pop", "/url"), "Confessions on a Dance Floor"),
                new Album(2, new Artist(2, "Britney Spears", "Pop", "/url"), "In the zone"),
                new Album(3, new Artist(4, "David Guetta", "Electronica", "/url"), "Nothing but the beat"),
                new Album(4, new Artist(5, "Arbat", "Electronica", "/url"), "Flame"),
                new Album(5, new Artist(3, "Justin Bieber", "Pop", "/url"), "Purpose"),
                new Album(6, new Artist(6, "Tale of Us", "Electronica", "/url"), "Purpose")
                );
    }

    @Bean(name = "tracks")
    public List<Track> getTracks(){
        return Arrays.asList(new Track(1, "Hung Up", new Album(1, new Artist(1, "Madonna", "Pop", "/url"), "Confessions on a Dance Floor"), 10000, 4),
                new Track(2, "cancion 1", new Album(2, new Artist(2, "Britney Spears", "Pop", "/url"), "In the zone"), 10000, 2),
                new Track(3, "cancion 2", new Album(2, new Artist(2, "Britney Spears", "Pop", "/url"), "In the zone"), 500, 3),
                new Track(4, "cancion 3", new Album(2, new Artist(2, "Britney Spears", "Pop", "/url"), "In the zone"), 600, 2),
                new Track(5, "cancion 4", new Album(2, new Artist(2, "Britney Spears", "Pop", "/url"), "In the zone"), 700, 3),
                new Track(6, "cancion 5", new Album(2, new Artist(2, "Britney Spears", "Pop", "/url"), "In the zone"), 300, 5),
                new Track(7, "cancion 6", new Album(2, new Artist(2, "Britney Spears", "Pop", "/url"), "In the zone"), 689, 3),
                new Track(8, "cancion 7", new Album(2, new Artist(2, "Britney Spears", "Pop", "/url"), "In the zone"), 689, 3),
                new Track(9, "cancion 7", new Album(3, new Artist(4, "David Guetta", "Electronica", "/url"), "Nothing but the beat"), 689, 3),
                new Track(10, "cancion 7", new Album(4, new Artist(5, "Arbat", "Electronica", "/url"), "Flame"), 2000, 8),
                new Track(11, "cancion 7", new Album(5, new Artist(3, "Justin Bieber", "Pop", "/url"), "Purpose"), 1500, 8),
                new Track(112, "cancion 7", new Album(6, new Artist(6, "Tale of Us", "Electronica", "/url"), "Purpose"), 1600, 8)
        );
    }
}
