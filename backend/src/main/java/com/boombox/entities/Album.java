package com.boombox.entities;

import java.sql.Date;

/* Album POJO class */
public class Album {
    private int id;
    private int artistId;
    private String albumIndex;
    private String artistIndex;
    private String name;
    private Date releaseDate;
    private float rating;
    private int isDeleted;
    private int pictureId;

    private String artistName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setRelease_date(Date release_date) {
        this.releaseDate = release_date;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int isDeleted() {
        return isDeleted;
    }

    public void setDeleted(int deleted) {
        isDeleted = deleted;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    public String getAlbumIndex() {
        return albumIndex;
    }

    public void setAlbumIndex(String albumIndex) {
        this.albumIndex = albumIndex;
    }

    public String getArtistIndex() {
        return artistIndex;
    }

    public void setArtistIndex(String artistIndex) {
        this.artistIndex = artistIndex;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", artistId=" + artistId +
                ", name='" + name + '\'' +
                ", release_date=" + releaseDate +
                ", rating=" + rating +
                ", isDeleted=" + isDeleted +
                ", pictureId=" + pictureId +
                '}';
    }
}
