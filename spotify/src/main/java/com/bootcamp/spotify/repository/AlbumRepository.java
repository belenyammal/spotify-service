package com.bootcamp.spotify.repository;


import com.bootcamp.spotify.domain.model.Album;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long> {

}
