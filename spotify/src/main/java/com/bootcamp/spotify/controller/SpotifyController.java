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
    @GetMapping(path = "/artist/{id}")
    public Artist retriveArtist(@PathVariable("id") Long id) {
        return artistService.getArtist(id);
    }

    @GetMapping(path = "/artists")
    public List<Artist> retriveArtist() {
        return artistService.getArtists();
    }

    @PostMapping(path = "/artist/")
    public Artist createArtist(@Validated @RequestBody ArtistRequest request) {
        return artistService.createArtist(request);
    }

    @PutMapping(path = "/artist/{id}")
    public Artist editArtist(@Validated @RequestBody ArtistRequest request, @PathVariable("id") Long id) {
        return artistService.editArtist(request, id);
    }

    @DeleteMapping(path = "/artist/{id}")
    public Artist deleteArtist(@PathVariable("id") Long id) {
        return artistService.deleteArtist(id);
    }

    //Album
    @GetMapping(path = "/album/{idAlbum}")
    public Album retriveAlbum(@PathVariable("idAlbum") Long idAlbum) {
        return albumService.getAlbum(idAlbum);
    }

    @GetMapping(path = "/albums")
    public List<Album> retriveAlbum() {
        return albumService.getAlbums();
    }

    @PostMapping(path = "/album/")
    public Album createAlbum(@Validated @RequestBody AlbumRequest request) {
        return albumService.createAlbum(request);
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
    @GetMapping(path = "/track/{id}")
    public Track retriveTrack(@PathVariable("id") Long id) {
        return trackService.getTrack(id);
    }

    @GetMapping(path = "/tracks")
    public List<Track> retriveTrack() {
        return trackService.getTracks();
    }

    @PostMapping(path = "/track/")
    public Track createTrack(@Validated @RequestBody TrackRequest request) {
        return trackService.createTrack(request);
    }

    @PutMapping(path = "/track/{id}")
    public Track editTrack(@Validated @RequestBody TrackRequest request, @PathVariable("id") Long id) {
        return trackService.editTrack(request, id);
    }

    @DeleteMapping(path = "/track/{id}")
    public Track deleteTrack(@PathVariable("id") Long id) {
        return trackService.deleteTrack(id);
    }
}
