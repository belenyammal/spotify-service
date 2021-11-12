package com.bootcamp.spotify.repository;


import com.bootcamp.spotify.domain.model.Album;
import com.bootcamp.spotify.domain.model.Artist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long> {
    Album findByIdAlbum(Long idAlbum);

    Album deleteByIdAlbum(Long idAlbum);

    List<Album> findAll();
}
