package com.bootcamp.spotify.controller.request;

import com.bootcamp.spotify.domain.model.Album;
import com.bootcamp.spotify.domain.model.Artist;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class TrackRequest {

    private long idTrack;
    @NotBlank(message = "El campo name no puede ser null o vacio.")
    private String name;
    private Album album;
    private int reproduction;
    private int duration;
}
