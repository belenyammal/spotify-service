package com.bootcamp.spotify.exceptions;

public class SpotifyExistException extends RuntimeException {

    public SpotifyExistException(String message){
        super(message);
    }
}
