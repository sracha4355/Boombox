package com.boombox.dao;

import com.boombox.entities.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AuthorRepository extends CrudRepository<Author,Long> {
    Optional<Author> findByUsername(String username);
    Optional<Author> findByEmail(String email);

}
