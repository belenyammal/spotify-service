package com.bootcamp.spotify.repository;

import com.bootcamp.spotify.domain.model.Artist;
import com.bootcamp.spotify.domain.model.Track;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TrackRepository extends CrudRepository<Track, Long> {
    Track findByIdTrack(Long id);

    Track deleteByIdTrack(Long id);

    List<Track> findAll();

    @Transactional
    @Modifying
    @Query(value = "update Track set reproduction = reproduction+1 where id_track = ?1", nativeQuery = true)
    Track incrementar (Long idTrack);

    @Query(value = "select top 5 * from track order by reproduction desc", nativeQuery = true)
    List<Track> cancionesPopulares();
    /*
    @Query(value = "select Track.name, Track.reproduction, Artist.name as artista from Track inner join Album on Track.id_album= Album.id_album inner join Artist on Album.id_artist = Artist.id_artist where Artist.id_artist = ?1 order by Track.reproduction desc", nativeQuery = true)
    List<Track> topCancionesArtist(Long id);
     */
}
