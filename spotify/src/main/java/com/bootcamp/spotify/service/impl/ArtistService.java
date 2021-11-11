package com.bootcamp.spotify.service.impl;

import com.bootcamp.spotify.controller.request.ArtistRequest;
import com.bootcamp.spotify.domain.mappers.ArtistMapper;
import com.bootcamp.spotify.domain.model.Artist;
import com.bootcamp.spotify.exceptions.SpotifyExistException;
import com.bootcamp.spotify.exceptions.SpotifyNoExistException;
import com.bootcamp.spotify.service.IArtistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ArtistService implements IArtistService {

    @Autowired
    private ArtistMapper artistMapper;

    @Qualifier("artists")
    @Autowired
    private List<Artist> artists;

    private Map<Long, Artist> artistsMap;

    @PostConstruct
    public void init() {
        //se ejecuta solo una vez cuando se crea el Bean
        artistsMap = new HashMap<>();
        artists.stream().forEach(artist -> {
            artistsMap.put(artist.getIdArtist(), artist);
        });
    }

    @Override
    public Artist getArtist(Long id) {
        return artistsMap.get(id);
    }

    @Override
    public List<Artist> getArtists() {
        return new ArrayList<>(artistsMap.values());
    }

    @Override
    public Artist createArtist(ArtistRequest request) {
        Artist artist = artistMapper.apply(request);
        if (artistsMap.get(request.getIdArtist()) == null) {
            artistsMap.put(request.getIdArtist(), artistMapper.apply(request));
        } else {
            log.error("El artista ya existe");
            throw new SpotifyExistException("El Artista ya existe");
        }
        return artist;
    }

    @Override
    public Artist editArtist(ArtistRequest request, Long id) {
        Artist artist = null;
        if (artistsMap.get(id) != null) {
            artist = artistMapper.apply(request);
            artistsMap.remove(request.getIdArtist());
            artistsMap.put(request.getIdArtist(), artist);
        } else {
            log.error("El artista NO existe");
            throw new SpotifyNoExistException("El artista NO existe");
        }
        return artist;
    }

    @Override
    public Artist deleteArtist(Long id) {
        return artistsMap.remove(id);
    }
}
