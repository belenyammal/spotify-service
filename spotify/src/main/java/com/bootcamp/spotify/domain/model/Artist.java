package com.bootcamp.spotify.domain.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idArtist;
    private String name;
    private String genre;
    private String image;

}
