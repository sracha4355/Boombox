package com.boombox.service.impl;

import com.boombox.dao.ArtistDao;
import com.boombox.entities.Artist;
import com.boombox.exceptions.artist.ArtistCouldNotBeCreatedException;
import com.boombox.exceptions.artist.ArtistNotFoundException;
import com.boombox.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService {
    @Autowired
    ArtistDao artistDao;
    @Override
    public Artist getByName(String artistName) {
        Optional<Artist> optional = artistDao.getByName(artistName);
        return checkIfExistsAndThrowIfNot(optional).get();
    }
    @Override
    public Artist getArtistById(int id) {
        Optional<Artist> optional = artistDao.get(id);
        return checkIfExistsAndThrowIfNot(optional).get();
    }

    private Optional<Artist> checkIfExistsAndThrowIfNot(Optional<Artist> optional) {
        if (!optional.isPresent()) {
            throw new ArtistNotFoundException("Artist not found");
        }
        return optional;
    }
    @Override
    public Artist createArtist(String artistName) {
        Artist artist = new Artist();
        artist.setName(artistName);
        Optional<Artist> optional = artistDao.create(artist);
        if(optional.isPresent()){
            return optional.get();
        } else {
            throw new ArtistCouldNotBeCreatedException(
                    "Creation of artist failed, this may be due to the artist already existing"
            );
        }
    }

    @Override
    public boolean deleteArtist(String artistName) {
        return artistDao.delete(artistName);
    }

    @Override
    public boolean deleteArtistById(int id) {
        return false;
    }

    @Override
    public boolean updateArtist(Map<String, String> parameters, String artistName) {
        return false;
    }
}
