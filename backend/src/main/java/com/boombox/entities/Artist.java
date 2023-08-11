package com.boombox.entities;

public class Artist {
    private int id;
    private String artistIndex;
    private String name;
    private int isDeleted;
    private int pictureId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArtistIndex() {
        return artistIndex;
    }

    public void setArtistIndex(String artistIndex) {
        this.artistIndex = artistIndex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsDeleted() {
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

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", artistIndex='" + artistIndex + '\'' +
                ", name='" + name + '\'' +
                ", isDeleted=" + isDeleted +
                ", pictureId=" + pictureId +
                '}';
    }
}
