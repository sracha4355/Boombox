package com.boombox.service.impl;

import com.boombox.dao.AuthorRepository;
import com.boombox.entities.Author;
import com.boombox.exceptions.general.EntityCouldNotBeCreated;
import com.boombox.exceptions.general.EntityNotFoundException;
import com.boombox.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository repository;
    private final String EMAIL_REGEX = "^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,})$";

    @Override
    public Author getAuthorByUsername(String username) {
        Optional<Author> author = repository.findByUsername(username);
        return unwrap(author);
    }

    @Override
    public Author getAuthorByEmail(String email) {
        Optional<Author> author = repository.findByEmail(email);
        return unwrap(author);
    }

    @Override
    public Author updateAuthor(long id) {
        Optional<Author> optional = repository.findById(id);
        Author author = unwrap(optional);
        repository.save(author);
        return author;
    }

    @Override
    public boolean deleteAuthor(long id) {
        Optional<Author> optional = repository.findById(id);
        Author author = unwrap(optional);
        if (author == null)
            throw new EntityNotFoundException(
                    "Author could not be deleted because an Author with id: " +id+ "could not be found"
            );
        repository.deleteById(author.getId());
        return true;
    }

    @Override
    public boolean softDeleteAuthor(long id) {
        Optional<Author> optional = repository.findById(id);
        Author author = unwrap(optional);
        if (author == null)
            throw new EntityNotFoundException(
                    "Author could not be soft-deleted because an Author with id: " +id+ "could not be found"
            );
        author.setIsDeleted(1);
        return true;
    }

    @Override
    public Author createAuthor(Author author) {
        if(!validAuthor(author))
            throw new EntityCouldNotBeCreated("Author could not be created");

        Optional<Author> emailCall = repository.findByEmail(author.getEmail());
        if(unwrap(emailCall) != null)
            throw new EntityCouldNotBeCreated(
                    "Author/User with email: "+author.getEmail()+" exists"
            );
        Optional<Author> usernameCall = repository.findByUsername(author.getUsername());
        if(unwrap(usernameCall) != null)
            throw new EntityCouldNotBeCreated(
                    "Author/User with username: "+author.getUsername()+" exists"
            );

        author.setIsDeleted(0);
        repository.save(author);
        return author;
    }

    private Author unwrap(Optional<Author> author){
        if(author.isPresent())
            return author.get();
        throw new EntityNotFoundException("Author could not be found");
    }

    private boolean validAuthor(Author author){
        if (author.getUsername() != null && author.getEmail() != null  && isValidEmail(author.getEmail()))
            return true;
        return false;
    }

    private boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
