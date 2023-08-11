package com.boombox.service;

import com.boombox.entities.Album;
import com.boombox.entities.Artist;

import java.util.List;
import java.util.Map;

public interface AlbumService {
    public List<Album> getByName(String albumName);
    public Album createAlbum(String albumName);

    public Album createAlbum(Album artist);
    public Album getAlbumById(int id);

    public Album getAlbumByNameAndArtistName(String param, String param2);

    public boolean deleteAlbum(String albumName);

    public boolean deleteAlbumById(int id);

    public boolean updateAlbum(Map<String, String> parameters, String albumName);
}
