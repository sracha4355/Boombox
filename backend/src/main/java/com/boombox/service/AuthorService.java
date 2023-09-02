package com.boombox.service;


import com.boombox.entities.Author;

public interface AuthorService {
    /*
    * NEEDS:
    * READ calls by criteria
    * UPDATE calls by criteria
    * DELETE calls
    * CREATE class
    * */

    Author getAuthorByUsername(String arg);
    Author getAuthorByEmail(String arg);
    Author updateAuthor(long id);
    boolean deleteAuthor(long id);
    boolean softDeleteAuthor(long id);
    Author createAuthor(Author author);
}
