package com.bootcamp.spotify.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Track {
    private long id;
    private String name;
    private long idArtist;
    private long idAlbum;
    private int reproduction;
    private int duration;
}
