package com.bootcamp.spotify.service.impl;

import com.bootcamp.spotify.controller.request.AlbumRequest;
import com.bootcamp.spotify.controller.request.TrackRequest;
import com.bootcamp.spotify.domain.mappers.TrackMapper;
import com.bootcamp.spotify.domain.model.Album;
import com.bootcamp.spotify.domain.model.Track;
import com.bootcamp.spotify.exceptions.SpotifyExistException;
import com.bootcamp.spotify.exceptions.SpotifyNoExistException;
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

    @Qualifier("tracks")
    @Autowired
    private List<Track> tracks;

    private Map<Long, Track> trackMap;

    @PostConstruct
    public void init() {
        trackMap = new HashMap<>();
        tracks.stream().forEach(track -> {
            trackMap.put(track.getId(), track);
        });
    }

    @Override
    public Track getTrack(Long id) {
        return trackMap.get(id);
    }

    @Override
    public List<Track> getTracks() {
        return new ArrayList<>(trackMap.values()) ;
    }

    @Override
    public Track createTrack(TrackRequest request) {
        Track track = trackMapper.apply(request);
        if (trackMap.get(request.getId()) == null) {
            trackMap.put(request.getId(), trackMapper.apply(request));
        } else {
            log.error("El track ya existe");
            throw new SpotifyExistException("El track ya existe");
        }
        return track;
    }

    @Override
    public Track editTrack(TrackRequest request, Long id) {
        Track track = null;
        if (trackMap.get(id) != null) {
            track = trackMapper.apply(request);
            trackMap.remove(request.getId());
            trackMap.put(request.getId(), track);
        } else {
            log.error("El track NO existe");
            throw new SpotifyNoExistException("El track NO existe");
        }
        return track;
    }

    @Override
    public Track deleteTrack(Long id) {
        return trackMap.remove(id);
    }

    //Incrementar el reproduction en uno
    public Track incrementarReproduccion(Long id) {
        Track trackR = trackMap.get(id);
        trackR.setReproduction(trackR.getReproduction() + 1);
        return trackR;
    }
}
