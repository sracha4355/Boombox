package com.boombox.controllers;

import com.boombox.enitity.response.AuthorResponse;
import com.boombox.entities.Author;
import com.boombox.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/boombox/author")
public class AuthorController {

    @Autowired
    AuthorService service;

    @GetMapping("/get/username/{username}")
    public ResponseEntity<AuthorResponse> getAuthorByUsername(@PathVariable String username){
        Author author = service.getAuthorByUsername(username);
        return new ResponseEntity<>(
                fillAuthorResponse(author),
                HttpStatus.OK
        );
    }

    @GetMapping("/get/email/{email}")
    public ResponseEntity<AuthorResponse> getAuthorByEmail(@PathVariable String email){
        Author author = service.getAuthorByEmail(email);
        return new ResponseEntity<>(
                fillAuthorResponse(author),
                HttpStatus.OK
        );
    }



    private AuthorResponse fillAuthorResponse(Author author){
        return new AuthorResponse(
                author.getUsername(),
                author.getEmail(),
                author.getId(),
                author.getPictureId()
        );
    }


}
