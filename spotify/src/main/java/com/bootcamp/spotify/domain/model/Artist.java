package com.bootcamp.spotify.domain.model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Artist {

    private long idArtist;
    private String name;
    private String genre;
    private String image;
}
