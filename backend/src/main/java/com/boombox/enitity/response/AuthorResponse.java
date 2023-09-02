package com.boombox.enitity.response;

import com.boombox.entities.Author;

public class AuthorResponse {
    private String username;
    private String email;
    private Long id;
    private Long pictureId;

    AuthorResponse(){}

    public AuthorResponse(String username, String email, Long id, Long pictureId) {
        this.username = username;
        this.email = email;
        this.id = id;
        this.pictureId = pictureId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long isPictureId() {
        return pictureId;
    }

    public void setPictureId(Long pictureId) {
        this.pictureId = pictureId;
    }
}
