package com.boombox.mappers;


import com.boombox.entities.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class AlbumRowMapper implements RowMapper<Album> {
    @Override
    public Album mapRow(ResultSet rs, int rowNum) throws SQLException {
        Album album = new Album();

        album.setArtistId(rs.getInt("ARTIST_ID"));
        album.setDeleted(rs.getInt("IS_DELETED"));
        album.setId(rs.getInt("ID"));
        album.setRating(rs.getFloat("RATING"));
        album.setPictureId(rs.getInt("PICTURE_ID"));
        album.setRelease_date(rs.getDate("RELEASE_DATE"));
        album.setName(rs.getString("NAME"));
        album.setArtistIndex(rs.getString("ARTIST_INDEX"));
        album.setAlbumIndex(rs.getString("ALBUM_INDEX"));
        album.setArtistName(rs.getString("ARTIST_NAME"));

        return album;
    }
}
