package com.bootcamp.spotify.domain.mappers;

import com.bootcamp.spotify.controller.request.ArtistRequest;
import com.bootcamp.spotify.domain.model.Artist;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ArtistMapper implements Function<ArtistRequest, Artist> {

    @Override
    public Artist apply(ArtistRequest artistRequest) {
        return new Artist(artistRequest.getIdArtist(), artistRequest.getName(), artistRequest.getGenre(),artistRequest.getImage());
    }
}
