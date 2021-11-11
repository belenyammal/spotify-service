package com.bootcamp.spotify.controller.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class AlbumRequest{

    @NotNull(message = "El campo id no puede ser null.")
    private long idAlbum;

    private long idArtist;

    private String name;

}
