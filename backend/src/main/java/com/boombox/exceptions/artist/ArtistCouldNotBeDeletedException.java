package com.boombox.exceptions.artist;

public class ArtistCouldNotBeDeletedException extends RuntimeException{
    public ArtistCouldNotBeDeletedException(String message) {
        super(message);
    }

    public ArtistCouldNotBeDeletedException(String message, Throwable cause) {
        super(message, cause);
    }
}
