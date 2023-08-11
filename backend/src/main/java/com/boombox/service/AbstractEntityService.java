package com.boombox.service;

import com.boombox.entities.Artist;

import java.util.Map;

public interface AbstractEntityService<T> {
    public T getByName(String name);
    public T create(String name);
    public T getById(int id);

    public boolean delete(String name);

    public boolean deleteId(int id);

    public boolean update(Map<String, String> parameters, String param);
}
