package com.bootcamp.spotify.service.impl;

import com.bootcamp.spotify.controller.request.AlbumRequest;
import com.bootcamp.spotify.domain.mappers.AlbumMapper;
import com.bootcamp.spotify.domain.model.Album;
import com.bootcamp.spotify.domain.model.Artist;
import com.bootcamp.spotify.exceptions.SpotifyExistException;
import com.bootcamp.spotify.exceptions.SpotifyNoExistException;
import com.bootcamp.spotify.repository.AlbumRepository;
import com.bootcamp.spotify.repository.ArtistRepository;
import com.bootcamp.spotify.service.IAlbumService;
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
public class AlbumService implements IAlbumService {

    @Autowired
    private AlbumMapper albumMapper;

    @Autowired
    private AlbumRepository albumRepository;

    @Qualifier("albums")
    @Autowired
    private List<Album> albums;

    private Map<Long, Album> albumMap = new HashMap<>();

    @PostConstruct
    public void init() {
        albums.stream().forEach(album -> {
            albumRepository.save(album);
        });
    }
    @Override
    public Album getAlbum(Long id) {
        return albumRepository.findByIdAlbum(id);
    }

    @Override
    public List<Album> getAlbums() {
        return albumRepository.findAll() ;
    }


    @Override
    public Album createAlbum(AlbumRequest request) {
        Album album = albumMapper.apply(request);
        if (albumRepository.findByIdAlbum(request.getIdAlbum()) != null) {
            log.error("El album ya existe");
            throw new SpotifyExistException("El album ya existe");
        } else {
            albumRepository.save(albumMapper.apply(request));
        }
        return album;
    }

    @Override
    public Album editAlbum(AlbumRequest request, Long id) {
        Album album = null;
        if (albumRepository.findByIdAlbum(id) != null) {
            album = albumMapper.apply(request);
            albumRepository.save(album);
        } else {
            log.error("El album NO existe");
            throw new SpotifyNoExistException("El album NO existe");
        }
        return album;
    }

    @Override
    public Album deleteAlbum(Long id) {
        albumRepository.deleteByIdAlbum(id);
        return null;
    }

}
