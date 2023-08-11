package com.boombox.exceptions.artist;

import com.boombox.entities.Artist;

public class ArtistAlreadyExistsException extends RuntimeException
{
    private Artist existingArtist;
    public ArtistAlreadyExistsException(String message, Artist existingArtist) {
        super(message);
        this.existingArtist = existingArtist;
    }

    public ArtistAlreadyExistsException(String message, Throwable cause, Artist existingArtist) {
        super(message, cause);
        this.existingArtist = existingArtist;
    }

    public Artist getExistingArtist() {
        return existingArtist;
    }
}
