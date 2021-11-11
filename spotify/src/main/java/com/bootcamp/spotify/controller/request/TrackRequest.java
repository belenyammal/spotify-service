package com.bootcamp.spotify.controller.request;

import com.bootcamp.spotify.domain.model.Album;
import com.bootcamp.spotify.domain.model.Artist;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class TrackRequest {
    @NotNull(message = "El campo id no puede ser null.")
    private long id;
    private String name;
    private Album album;
    private int reproduction;
    private int duration;
}
