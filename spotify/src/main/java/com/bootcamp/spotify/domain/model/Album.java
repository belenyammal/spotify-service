package com.bootcamp.spotify.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAlbum;
    @ManyToOne
    @JoinColumn(name="idArtist")
    private Artist artist;
    private String name;

}
