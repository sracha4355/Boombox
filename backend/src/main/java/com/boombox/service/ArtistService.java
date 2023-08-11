package com.boombox.service;

import com.boombox.entities.Artist;

import java.util.Map;

public interface ArtistService {
     public Artist getByName(String artistName);
     public Artist createArtist(String artistName);
     public Artist getArtistById(int id);

     public boolean deleteArtist(String artistName);

     public boolean deleteArtistById(int id);

     public boolean updateArtist(Map<String, String> parameters, String artistName);

}
