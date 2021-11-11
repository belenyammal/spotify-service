package com.bootcamp.spotify.service;

import com.bootcamp.spotify.controller.request.ArtistRequest;
import com.bootcamp.spotify.domain.model.Artist;

import java.util.List;

public interface IArtistService {
    Artist getArtist(Long id);

    List<Artist> getArtists();

    Artist createArtist(ArtistRequest request);

    Artist editArtist(ArtistRequest request, Long id);

    Artist deleteArtist(Long id);

}

