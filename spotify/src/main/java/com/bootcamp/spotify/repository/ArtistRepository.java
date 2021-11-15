package com.bootcamp.spotify.repository;

import com.bootcamp.spotify.domain.model.Artist;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepository extends CrudRepository<Artist, Long> {

    Artist findByIdArtist(Long idArtist);

    Artist deleteByIdArtist(Long idArtist);

    List<Artist> findAll();

    @Query(value = "select top 5 ar.id_artist, ar.name, ar.genre, ar.image from track t join  album a on a.id_album = t.id_album join artist ar on ar.id_artist=a.id_artist group by ar.id_artist, ar.name, ar.genre, ar.image order by sum(reproduction) desc", nativeQuery = true)
    List<Artist> topArtistas();

}
