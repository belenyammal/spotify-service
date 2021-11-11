package com.bootcamp.spotify.repository;

import com.bootcamp.spotify.domain.model.Track;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends CrudRepository<Track, Long> {

}
