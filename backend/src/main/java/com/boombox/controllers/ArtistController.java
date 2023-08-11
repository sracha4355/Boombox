package com.boombox.controllers;

import com.boombox.entities.Artist;
import com.boombox.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.boombox.enitity.response.ArtistResponse;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/boombox/artist")
public class ArtistController {

    @Autowired
    private ArtistService artistService;


    @GetMapping("/get/id/{id}")
    public ResponseEntity<ArtistResponse> artistById(@PathVariable int id){
        Artist artist = artistService.getArtistById(id);
        ArtistResponse res = new ArtistResponse(
                artist.getId(),
                artist.getArtistIndex(),
                artist.getName(),
                artist.getIsDeleted(),
                artist.getPictureId()
        );
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


    @GetMapping("/get/name/{name}")
    public ResponseEntity<Object> getArtistByName(@PathVariable("name") String artistName){
        Artist artist = artistService.getByName(artistName);
        ArtistResponse res = new ArtistResponse(
                artist.getId(),
                artist.getArtistIndex(),
                artist.getName(),
                artist.getIsDeleted(),
                artist.getPictureId()
        );
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/create/name/{name}")
    public ResponseEntity<ArtistResponse> createArtist(@PathVariable("name") String artistName){
        Artist artist = artistService.createArtist(artistName);
        ArtistResponse res = new ArtistResponse(
                artist.getId(),
                artist.getArtistIndex(),
                artist.getName(),
                artist.getIsDeleted(),
                artist.getPictureId()
        );
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/name/{name}")
    public ResponseEntity<Object> deleteArtist(@PathVariable("name") String artistName){
        boolean result = artistService.deleteArtist(artistName);
        String res = "Artist: " + artistName + " successfully deleted";
        Map<String, String> JSONMap = new HashMap<>();
        JSONMap.put("deletionResult", "success");
        JSONMap.put("message", res);
        return new ResponseEntity<>(JSONMap, HttpStatus.CREATED);
    }

}
