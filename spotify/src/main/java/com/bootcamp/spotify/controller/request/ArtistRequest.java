package com.bootcamp.spotify.controller.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Builder
@Data
public class ArtistRequest {

    @NotNull(message = "El campo id no puede ser null.")
    private long idArtist;

    private String name;

    private String genre;

    private String image;

}