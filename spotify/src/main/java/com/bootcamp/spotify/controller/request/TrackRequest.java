package com.bootcamp.spotify.controller.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class TrackRequest {
    @NotNull(message = "El campo id no puede ser null.")
    private long id;
    private String name;
    private long idArtist;
    private long idAlbum;
    private int reproduction;
    private int duration;
}
