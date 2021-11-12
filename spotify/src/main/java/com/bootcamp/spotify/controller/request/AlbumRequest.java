package com.bootcamp.spotify.controller.request;

import com.bootcamp.spotify.domain.model.Artist;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class AlbumRequest{

    private long idAlbum;

    private Artist artist;

    @NotBlank(message = "El campo name no puede ser null o vacio.")
    private String name;

}
