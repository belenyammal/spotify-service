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

    @Bean(name = "albums")
    public List<Album> getAlbums(){
        return Arrays.asList(new Album(1, 1, "Confessions on a Dance Floor"));
    }

    @Bean(name = "artists")
    public List<Artist> getArtists(){
        return Arrays.asList(new Artist(1, "Madonna", "Pop", "/url"));
    }

    @Bean(name = "tracks")
    public List<Track> getTracks(){
        return Arrays.asList(new Track(1, "Hung Up", 1, 1, 10000, 4));
    }
}
