package com.bootcamp.spotify.controller;

import com.bootcamp.spotify.controller.request.AlbumRequest;
import com.bootcamp.spotify.controller.request.ArtistRequest;
import com.bootcamp.spotify.controller.request.TrackRequest;
import com.bootcamp.spotify.domain.model.Album;
import com.bootcamp.spotify.domain.model.Artist;
import com.bootcamp.spotify.domain.model.Track;
import com.bootcamp.spotify.service.impl.AlbumService;
import com.bootcamp.spotify.service.impl.ArtistService;
import com.bootcamp.spotify.service.impl.TrackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/spotify")

public class SpotifyController {

    @Autowired
    private ArtistService artistService;

    @Autowired
    private AlbumService albumService;

    @Autowired
    private TrackService trackService;

    //Artist

    @PostMapping(path = "/artist")
    public Artist createArtist(@Validated @RequestBody ArtistRequest request) {
        return artistService.createArtist(request);
    }

    @GetMapping(path = "/artist/{idArtist}")
    public Artist retriveArtist(@PathVariable("idArtist") Long id) {
        return artistService.getArtist(id);
    }

    @PutMapping(path = "/artist/{idArtist}")
    public Artist editArtist(@Validated @RequestBody ArtistRequest request, @PathVariable("idArtist") Long id) {
        return artistService.editArtist(request, id);
    }

    @DeleteMapping(path = "/artist/{idArtist}")
    public Artist deleteArtist(@PathVariable("idArtist") Long id) {
        return artistService.deleteArtist(id);
    }

    //devuelve los top 5 artistas populares
    @GetMapping(path = "/artist/rank")
    public List<Artist> retriveArtist() {
        return artistService.getTopArtistas();
    }


    //Album
    @GetMapping(path = "/album")
    public List<Album> retriveAlbum() {
        return albumService.getAlbums();
    }

    @PostMapping(path = "/album")
    public Album createAlbum(@Validated @RequestBody AlbumRequest request) {
        return albumService.createAlbum(request);
    }

    @GetMapping(path = "/album/{idAlbum}")
    public Album retriveAlbum(@PathVariable("idAlbum") Long idAlbum) {
        return albumService.getAlbum(idAlbum);
    }


    @PutMapping(path = "/album/{idAlbum}")
    public Album editAlbum(@Validated @RequestBody AlbumRequest request, @PathVariable("idAlbum") Long id) {
        return albumService.editAlbum(request, id);
    }

    @DeleteMapping(path = "/album/{idAlbum}")
    public Album deleteAlbum(@PathVariable("idAlbum") Long id) {
        return albumService.deleteAlbum(id);
    }

    //Track
    @PostMapping(path = "/track")
    public Track createTrack(@Validated @RequestBody TrackRequest request) {
        return trackService.createTrack(request);
    }

    //devuelve un track especifico y le incrementa una reproduccion
    @GetMapping(path = "/play/track/{idTrack}")
    public Track play(@PathVariable("idTrack") Long idTrack) {
        return trackService.incrementarReproduccion(idTrack);
    }

    @PutMapping(path = "/track/{idTrack}")
    public Track editTrack(@Validated @RequestBody TrackRequest request, @PathVariable("id") Long id) {
        return trackService.editTrack(request, id);
    }

    @DeleteMapping(path = "/track/{idTrack}")
    public Track deleteTrack(@PathVariable("idTrack") Long id) {
        return trackService.deleteTrack(id);
    }

    //devuelve el top 5 de las canciones mas populares
    @GetMapping(path = "/track/rank")
        public List<Track> retriveTrack(){ return trackService.topCancionesPopulares();}


    //devuelve el top 5 de canciones populares del artista
    /*
    @GetMapping(path = "/artist/{idArtist}/songs/rank")
    public List<Track> retrieveArtist(@PathVariable("idArtist") Long id) {
        return trackService.topCancionesArtista(id);
    }
    */

}
