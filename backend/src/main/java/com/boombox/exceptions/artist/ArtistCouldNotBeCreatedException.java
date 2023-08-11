package com.boombox.exceptions.artist;

public class ArtistCouldNotBeCreatedException extends RuntimeException{
    public ArtistCouldNotBeCreatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArtistCouldNotBeCreatedException(String message) {
        super(message);
    }
}
