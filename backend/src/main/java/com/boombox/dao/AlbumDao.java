package com.boombox.dao;

import com.boombox.entities.Album;
import com.boombox.entities.Artist;
import com.boombox.mappers.AlbumRowMapper;
import com.boombox.mappers.ArtistRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Component
public class AlbumDao extends AbstractDao<Album>{
    String RETRIEVE_BY_ALBUM_INDEX = "SELECT * FROM ALBUM WHERE ALBUM_INDEX= '%s' LIMIT 1";
    String RETRIEVE_BY_ALBUM_ID = "SELECT * FROM ALBUM WHERE ID= '%d' LIMIT 1";
    @Autowired
    ArtistDao artistDao;
    @Override
    public Optional<Album> get(int id) {
        String sql = String.format(RETRIEVE_BY_ALBUM_ID, id);
        try {
            return Optional.ofNullable(template.queryForObject(sql, new AlbumRowMapper()));
        } catch (DataAccessException ex){
            //ex.printStackTrace();
            return Optional.ofNullable(null);
        }
    }

    @Override
    public Album update(Album obj, String[] params) {
        return null;
    }

    public Optional<Album> getByAlbumNameAndArtistName(String albumName, String artistName){
        String stmt = "select * from album where album_index = ? and artist_index = ?";
        try {
            return Optional.ofNullable(
                    template.queryForObject(
                            stmt,
                            new Object [] {albumName.toUpperCase(), artistName.toUpperCase()},
                            new int [] {Types.VARCHAR, Types.VARCHAR},
                            new AlbumRowMapper()
                    )
            );
        } catch (DataAccessException ex){
            //ex.printStackTrace();
            return Optional.ofNullable(null);
        }
    }

    // artist_index also stored in album table -> change to make call only to album table
    public List<Album> getAllAlbumByArtist(String artistName){
        String sql = "select * from artist where artist_index = ? limit 1";
        int artistId = template.queryForObject(
                sql,
                new Object[]{artistName.toUpperCase()},
                new int[] {Types.VARCHAR},
                new ArtistRowMapper()
                ).getId();
        sql = "select * from album where artist_id = ?";
        return template.query(
                sql,
                new PreparedStatementSetter(){
                    @Override
                    public void setValues(PreparedStatement ps) throws SQLException {
                        ps.setInt(1, artistId);
                    }
                },
                new AlbumRowMapper()
        );
    }

    public List<Album> getAlbumByName(String albumName){
        String sql = "SELECT * FROM ALBUM WHERE ALBUM_INDEX=?";
        final String albumIndex = albumName.toUpperCase();
        List<Album> albums = template.query(
                sql,
                (p) -> {
                        p.setString(1, albumIndex);
                    },
                new AlbumRowMapper()
        );
        return albums;
    }

    @Override
    public Optional<Album> getByEntity(Album obj) {
        return Optional.empty();
    }

    // END OF GET METHODS

    // To use create properly, pass in a name and artist name of the album
    @Override
    public Optional<Album> create(Album obj){
        // check if album already exists
        if(getByAlbumNameAndArtistName(obj.getName(), obj.getArtistName()).isPresent()){
            return Optional.ofNullable(null);
        }

        Optional<Artist> optional = artistDao.getByName(obj.getArtistName());
        Artist artist;
        if(!optional.isPresent()){
            Artist tmp = new Artist();
            tmp.setName(obj.getArtistName());
            artistDao.create(tmp);
            artist = artistDao.getByName(obj.getArtistName()).get();
        } else {
            artist = optional.get();
        }
        String sql = "INSERT INTO ALBUM (" +
                "ARTIST_NAME, ARTIST_INDEX, ALBUM_INDEX, NAME, RELEASE_DATE, ARTIST_ID, RATING," +
                "IS_DELETED, PICTURE_ID)" +
                "VALUES(?,?,?,?,?,?,0,0,null)";
        final String artistName = artist.getName();
        final String artistIndex = artist.getName().toUpperCase();
        final String albumName = obj.getName();
        final String albumIndex = obj.getName().toUpperCase();
        final Date releaseDate = obj.getReleaseDate();
        final int artistId = artist.getId();

        template.update(sql,
                (ps) ->{
                    ps.setString(1, artistName);
                    ps.setString(2, artistIndex);
                    ps.setString(3, albumIndex);
                    ps.setString(4, albumName);
                    ps.setDate(5, releaseDate);
                    ps.setInt(6, artistId);
                 }
        );

        return getByAlbumNameAndArtistName(obj.getName(), obj.getArtistName());
    }

    @Override
    public boolean delete(Album obj) {
        return false;
    }

    /*
    @Override
    public Album update(Album obj, String[] params) {
        return null;
    }

    @Override
    public Album create(Album obj) {
        String artistIndex = obj.getArtistName().toUpperCase();
        Artist result = artistDao.getByName(artistIndex);
        if (result == null){
            Artist tmp = new Artist();
            tmp.setName(obj.getArtistName());
            result = artistDao.create(tmp);
        }
        final String artistIndexForQuery = obj.getArtistName().toUpperCase();
        final String albumIndexForQuery = obj.getName().toUpperCase();
        String sql = "select * from album where artist_index = ? and album_index = ? limit 1";
        List<Album> res = template.query(
                sql,
                new PreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps) throws SQLException {
                        ps.setString(1, artistIndexForQuery);
                        ps.setString(2, albumIndexForQuery);
                    }
                },
                new AlbumRowMapper()
        );
        if (res.size() != 0) return null;
        sql = "insert into album (artist_id, album_index, name, artist_index, artist_name, release_date, rating, is_deleted, picture_id) "+
                "VALUES (%d, %s, %s, %s, %s, %t, %f, %d, %d)";
        sql = String.format(sql, result.getId(), obj.getName().toUpperCase(),
                obj.getName(), obj.getArtistName().toUpperCase(), obj.getArtistName(),
                            obj.getRelease_date(), 0.0f ,0, obj.getPictureId());
        template.update(sql);
        // get album ready for returning without querying database again
        obj.setArtistId(result.getId());
        obj.setAlbumIndex(obj.getName().toUpperCase());
        obj.setArtistIndex(obj.getArtistName().toUpperCase());
        obj.setRating(0.0f);
        obj.setDeleted(0);
        return obj;
    }

    @Override
    public Album delete(Album obj) {
        return null;
    }
}
*/
}

