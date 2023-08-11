package com.boombox.enitity.response;

public class ArtistResponse {
    private int id;
    private String artistIndex;
    private String name;
    private int isDeleted;
    private int pictureId;
    public ArtistResponse(int id, String artistIndex, String name, int isDeleted, int pictureId) {
        this.id = id;
        this.artistIndex = artistIndex;
        this.name = name;
        this.isDeleted = isDeleted;
        this.pictureId = pictureId;
    }
    public ArtistResponse(){}

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

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }
}
