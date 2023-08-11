package com.boombox.service.impl;

import com.boombox.dao.AlbumDao;
import com.boombox.entities.Album;
import com.boombox.exceptions.general.EntityCouldNotBeCreated;
import com.boombox.exceptions.general.EntityNotFoundException;
import com.boombox.mappers.AlbumRowMapper;
import com.boombox.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    JdbcTemplate template;

    @Autowired
    AlbumDao albumDao;
    String RETRIEVE_BY_ALBUM_NAME = "SELECT * FROM ALBUM WHERE ARTIST_INDEX='%s'";
    @Override
    public List<Album> getByName(String albumName) {
        List<Album> res = albumDao.getAlbumByName(albumName);
        if(res.isEmpty()){
            String ERROR_MSG = "No albums by the name of "+albumName+" were found";
            throw new EntityNotFoundException(ERROR_MSG);
        }
        return res;
    }

    @Override
    public Album createAlbum(String albumName) {
        return null;
    }

    @Override
    public Album createAlbum(Album album){
        System.out.println(album.toString());
        Optional<Album> optional = albumDao.create(album);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            throw new EntityCouldNotBeCreated(album.getName() + " could not be created");
        }
    }


    @Override
    public Album getAlbumById(int id) {
        Optional<Album> optional = albumDao.get(id);
        if(optional.isPresent()){
            return optional.get();
        } else {
            throw new EntityNotFoundException("Album could not be found by specified id");
        }
    }

    @Override
    public Album getAlbumByNameAndArtistName(String albumName, String artistName) {
        Optional<Album> album = albumDao.getByAlbumNameAndArtistName(albumName, artistName);
        if(album.isPresent()){
            return album.get();
        } else {
            throw new EntityNotFoundException("Album: " + albumName + " by " + artistName +" not found");
        }
    }


    @Override
    public boolean deleteAlbum(String albumName) {
        return false;
    }

    @Override
    public boolean deleteAlbumById(int id) {
        return false;
    }

    @Override
    public boolean updateAlbum(Map<String, String> parameters, String albumName) {
        return false;
    }
}
