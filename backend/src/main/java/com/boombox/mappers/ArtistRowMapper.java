package com.boombox.mappers;

import com.boombox.entities.Album;
import com.boombox.entities.Artist;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtistRowMapper implements RowMapper<Artist> {

    @Override
    public Artist mapRow(ResultSet rs, int rowNum) throws SQLException {
        Artist res = new Artist();
        res.setId(rs.getInt("ID"));
        res.setArtistIndex(rs.getString("ARTIST_INDEX"));
        res.setDeleted(rs.getInt("IS_DELETED"));
        res.setPictureId(rs.getInt("PICTURE_ID"));
        res.setName(rs.getString("NAME"));
        return res;
    }
}
