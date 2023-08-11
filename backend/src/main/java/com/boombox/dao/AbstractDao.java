package com.boombox.dao;

import com.boombox.entities.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

public abstract class AbstractDao<T> {
    @Autowired
    JdbcTemplate template;
    public abstract Optional<T> get(int id);
    public abstract T update(T obj, String [] params);
    public abstract Optional<T> create(T obj);
    public abstract boolean delete(T obj);


    public abstract Optional<Album> getByEntity(Album obj);

}
