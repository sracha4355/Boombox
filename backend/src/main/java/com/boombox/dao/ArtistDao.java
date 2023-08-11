package com.boombox.dao;

import com.boombox.entities.Album;
import com.boombox.entities.Artist;
import com.boombox.exceptions.artist.ArtistAlreadyExistsException;
import com.boombox.exceptions.artist.ArtistCouldNotBeDeletedException;
import com.boombox.mappers.ArtistRowMapper;
import jdk.jshell.execution.JdiDefaultExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;
import java.util.List;

import javax.swing.text.html.Option;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;

@Component
public class ArtistDao extends AbstractDao<Artist>{
    @Autowired
    JdbcTemplate template;
    String RETRIEVE_BY_ARTIST_INDEX = "SELECT * FROM ARTIST WHERE ARTIST_INDEX= '%s' LIMIT 1";
    String DELETE_BY_ARTIST_INDEX = "DELETE FROM ARTIST WHERE ARTIST_INDEX= '%s'";
    public Optional<Artist> get(int id) {
        String sql = String.format("SELECT * FROM ARTIST WHERE ID = %d", id);
        try {
            Artist artist = template.queryForObject(sql, new ArtistRowMapper());
            Optional<Artist> optional = Optional.of(artist);
            return optional;
        } catch (DataAccessException dataAccessException) {
            return Optional.ofNullable(null);
        }
    }


    public Optional<Artist> getByName(String artistName){
        String sql = String.format(
                RETRIEVE_BY_ARTIST_INDEX,
                artistName.toUpperCase()
        );
        try {
            Artist artist = template.queryForObject(sql, new ArtistRowMapper());
            Optional<Artist> optional = Optional.of(artist);
            return optional;
        } catch (DataAccessException dataAccessException) {
            //dataAccessException.printStackTrace();
            return Optional.ofNullable(null);
        }
    }


    public Optional<Artist> create(Artist artist) {
        Optional<Artist> exist = getByName(artist.getName());
        if (exist.isPresent()){
            throw new ArtistAlreadyExistsException("Artist Already exists", exist.get());
        }
        // will have to create support for pictures later
        String sql = "INSERT INTO ARTIST (NAME, ARTIST_INDEX, IS_DELETED, PICTURE_ID) " +
                "VALUES (?, ?, 0, null)";
        final String artistName = artist.getName();
        final String artistIndex = artist.getName().toUpperCase();
        try {
            template.update(sql,
                    (ps) -> {
                        ps.setString(1, artistName);
                        ps.setString(2, artistIndex);
                    }
            );
            sql = String.format(RETRIEVE_BY_ARTIST_INDEX, artistIndex);
            artist = template.queryForObject(sql , new ArtistRowMapper());
            System.out.println();
        } catch (DataAccessException exception){
            //exception.printStackTrace();
            artist = null;
        }
        return Optional.ofNullable(artist);
    }

    public boolean delete(String artistIndex) {
        String sql = String.format(RETRIEVE_BY_ARTIST_INDEX, artistIndex.toUpperCase());
        final String tmp = sql;
        List<Artist> artists = template.query(
                (c) -> {
                    return c.prepareStatement(tmp);
                },
                new ArtistRowMapper()
        );

        if (artists.isEmpty()) {
            throw new ArtistCouldNotBeDeletedException("the artist could not be deleted");
        };

        // delete the object
        sql = String.format(DELETE_BY_ARTIST_INDEX, artistIndex.toUpperCase());
        template.update(sql);
        return true;
    }

    @Override
    public boolean delete(Artist obj) {
        return delete(obj.getName().toUpperCase());
    }

    @Override
    public Optional<Album> getByEntity(Album obj) {
        return Optional.empty();
    }

    @Override
    public Artist update(Artist obj, String[] params) {
        return null;
    }
}

