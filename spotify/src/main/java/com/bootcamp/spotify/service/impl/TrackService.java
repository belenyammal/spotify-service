package com.bootcamp.spotify.service.impl;

import com.bootcamp.spotify.controller.request.AlbumRequest;
import com.bootcamp.spotify.controller.request.TrackRequest;
import com.bootcamp.spotify.domain.mappers.TrackMapper;
import com.bootcamp.spotify.domain.model.Album;
import com.bootcamp.spotify.domain.model.Artist;
import com.bootcamp.spotify.domain.model.Track;
import com.bootcamp.spotify.exceptions.SpotifyExistException;
import com.bootcamp.spotify.exceptions.SpotifyNoExistException;
import com.bootcamp.spotify.repository.ArtistRepository;
import com.bootcamp.spotify.repository.TrackRepository;
import com.bootcamp.spotify.service.ITrackService;
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
public class TrackService implements ITrackService {

    @Autowired
    private TrackMapper trackMapper;

    @Autowired
    private TrackRepository trackRepository;

    @Qualifier("tracks")
    @Autowired
    private List<Track> tracks;

    private Map<Long, Track> trackMap = new HashMap<>();

    @PostConstruct
    public void init() {
        trackMap = new HashMap<>();
        tracks.stream().forEach(track -> {
            trackRepository.save(track);
        });
    }

    @Override
    public Track getTrack(Long id) {
        return trackRepository.findByIdTrack(id);
    }



    @Override
    public Track createTrack(TrackRequest request) {
        Track track = trackMapper.apply(request);
        if (trackRepository.findById(request.getIdTrack()) != null) {
            log.error("el artista ya existe");
            throw new SpotifyExistException("El artista ya existe");
        } else {
            trackRepository.save(trackMapper.apply(request));
        }
        return track;
    }

    @Override
    public Track editTrack(TrackRequest request, Long id) {
        Track track = null;
        if (trackRepository.findById(id) != null) {
            track = trackMapper.apply(request);
            trackRepository.save(track);
        } else {
            log.error("El track NO existe");
            throw new SpotifyNoExistException("El track NO existe");
        }
        return track;
    }

    @Override
    public Track deleteTrack(Long id) {
        trackRepository.deleteByIdTrack(id);
        return null;
    }

    //Incrementar el reproduction en uno
    public Track incrementarReproduccion(Long idTrack){
        return trackRepository.incrementar(idTrack);
    }

    @Override
    public List<Track> getTracks() {
        return trackRepository.findAll();
    }

    public  List<Track> topCancionesPopulares() {
        return trackRepository.cancionesPopulares();
    }
    /*
    public List<Track> topCancionesArtista(Long id) {
        return trackRepository.topCancionesArtist(id);
    }
     */
}
