package com.bootcamp.spotify.service;

import com.bootcamp.spotify.controller.request.AlbumRequest;
import com.bootcamp.spotify.controller.request.ArtistRequest;
import com.bootcamp.spotify.domain.model.Album;
import com.bootcamp.spotify.domain.model.Artist;

import java.util.List;
public interface IAlbumService {
    Album getAlbum(Long id);

    List<Album> getAlbums();

    Album createAlbum(AlbumRequest request);

    Album editAlbum(AlbumRequest request, Long id);

    Album deleteAlbum(Long id);
}
