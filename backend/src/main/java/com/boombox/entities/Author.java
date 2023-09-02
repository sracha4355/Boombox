package com.boombox.entities;

import jakarta.persistence.*;

@Entity
@Table(name="AUTHOR")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    @Column(name="picture_id")
    private Long pictureId;
    @Column(name="is_deleted")
    private int isDeleted;

    public Author(){}

    public Author(Long id, String username, String email, String password, Long pictureId, int isDeleted) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.pictureId = pictureId;
        this.isDeleted = isDeleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getPictureId() {
        return pictureId;
    }

    public void setPictureId(Long pictureId) {
        this.pictureId = pictureId;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int deleted) {
        isDeleted = deleted;
    }
}
