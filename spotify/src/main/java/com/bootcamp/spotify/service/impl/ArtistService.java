package com.bootcamp.spotify.service.impl;

import com.bootcamp.spotify.controller.request.ArtistRequest;
import com.bootcamp.spotify.domain.mappers.ArtistMapper;
import com.bootcamp.spotify.domain.model.Artist;
import com.bootcamp.spotify.exceptions.SpotifyExistException;
import com.bootcamp.spotify.exceptions.SpotifyNoExistException;
import com.bootcamp.spotify.repository.ArtistRepository;
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

    @Autowired
    private ArtistRepository artistRepository;

    @Qualifier("artists")
    @Autowired
    private List<Artist> artists;

    private Map<Long, Artist> artistsMap = new HashMap<>();

    @PostConstruct
    public void init() {
        //se ejecuta solo una vez cuando se crea el Bean
        artists.stream().forEach(artist -> {
            artistRepository.save(artist);
        });
    }

    @Override
    public Artist getArtist(Long id) {
        return artistRepository.findByIdArtist(id);
    }

    @Override
    public List<Artist> getArtists() {

        return artistRepository.findAll();

    }


    @Override
    public Artist createArtist(ArtistRequest request) {
        Artist artist = artistMapper.apply(request);
        if (artistRepository.findById(request.getIdArtist()) != null) {
            log.error("el artista ya existe");
            throw new SpotifyExistException("El artista ya existe");
        } else {
            artistRepository.save(artistMapper.apply(request));
        }
        return artist;
    }

    @Override
    public Artist editArtist(ArtistRequest request, Long id) {
        Artist artist = null;
        if (artistRepository.findById(id) != null) {
            artist = artistMapper.apply(request);
            artistRepository.save(artist);
        } else {
            log.error("El artista NO existe");
            throw new SpotifyNoExistException("El artista NO existe");
        }
        return artist;
    }

    @Override
    public Artist deleteArtist(Long id) {
        artistRepository.deleteByIdArtist(id);
        return null;
    }

    public List<Artist> getTopArtistas() {
        return artistRepository.topArtistas();
    }

}
