package com.bootcamp.spotify.domain.mappers;

import com.bootcamp.spotify.controller.request.AlbumRequest;
import com.bootcamp.spotify.controller.request.ArtistRequest;
import com.bootcamp.spotify.domain.model.Album;
import com.bootcamp.spotify.domain.model.Artist;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AlbumMapper implements Function<AlbumRequest, Album> {

    @Override
    public Album apply(AlbumRequest albumRequest) {
        return new Album(albumRequest.getIdAlbum(), albumRequest.getArtist(), albumRequest.getName());
    }
}
