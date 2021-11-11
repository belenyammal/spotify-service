package com.bootcamp.spotify.controller.request;

import com.bootcamp.spotify.domain.model.Artist;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class AlbumRequest{

    @NotNull(message = "El campo id no puede ser null.")
    private long idAlbum;

    private Artist artist;

    private String name;

}
