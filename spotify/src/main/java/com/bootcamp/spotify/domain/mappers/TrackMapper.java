package com.bootcamp.spotify.domain.mappers;

import com.bootcamp.spotify.controller.request.AlbumRequest;
import com.bootcamp.spotify.controller.request.TrackRequest;
import com.bootcamp.spotify.domain.model.Album;
import com.bootcamp.spotify.domain.model.Track;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TrackMapper implements Function<TrackRequest, Track> {

    @Override
    public Track apply(TrackRequest trackRequest) {
        return new Track(trackRequest.getId(), trackRequest.getName(), trackRequest.getIdArtist(), trackRequest.getIdAlbum(), trackRequest.getReproduction(), trackRequest.getDuration());
    }
}
