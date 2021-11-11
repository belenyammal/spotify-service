package com.bootcamp.spotify.service.impl;

import com.bootcamp.spotify.controller.request.AlbumRequest;
import com.bootcamp.spotify.domain.mappers.AlbumMapper;
import com.bootcamp.spotify.domain.model.Album;
import com.bootcamp.spotify.domain.model.Artist;
import com.bootcamp.spotify.exceptions.SpotifyExistException;
import com.bootcamp.spotify.exceptions.SpotifyNoExistException;
import com.bootcamp.spotify.service.IAlbumService;
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

    @Qualifier("albums")
    @Autowired
    private List<Album> albums;

    private Map<Long, Album> albumMap;

    @PostConstruct
    public void init() {
        albumMap = new HashMap<>();
        albums.stream().forEach(album -> {
            albumMap.put(album.getIdAlbum(), album);
        });
    }
    @Override
    public Album getAlbum(Long id) {
        return albumMap.get(id);
    }

    @Override
    public List<Album> getAlbums() {
        return new ArrayList<>(albumMap.values()) ;
    }


    @Override
    public Album createAlbum(AlbumRequest request) {
        Album album = albumMapper.apply(request);
        if (albumMap.get(request.getIdAlbum()) == null) {
            albumMap.put(request.getIdAlbum(), albumMapper.apply(request));
        } else {
            log.error("El album ya existe");
            throw new SpotifyExistException("El album ya existe");
        }
        return album;
    }

    @Override
    public Album editAlbum(AlbumRequest request, Long id) {
        Album album = null;
        if (albumMap.get(id) != null) {
            album = albumMapper.apply(request);
            albumMap.remove(request.getIdAlbum());
            albumMap.put(request.getIdAlbum(), album);
        } else {
            log.error("El album NO existe");
            throw new SpotifyNoExistException("El album NO existe");
        }
        return album;
    }

    @Override
    public Album deleteAlbum(Long id) {
        return albumMap.remove(id);
    }
}
