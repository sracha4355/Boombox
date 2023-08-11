package com.boombox.controllers;

import com.boombox.dao.AlbumDao;
import com.boombox.entities.Artist;
import com.boombox.service.impl.AlbumServiceImpl;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.boombox.entities.Album;

import java.util.List;

@RestController
@RequestMapping("/boombox/album")
public class AlbumController {
    @Autowired
    private AlbumServiceImpl albumService;

    @GetMapping("/get/id/{id}")
    public ResponseEntity<Object> getAlbumById(@PathVariable int id){
        Album album = albumService.getAlbumById(id);
        return new ResponseEntity<>(album, HttpStatus.OK);
    }

    @GetMapping("/get/all/albums/name/{name}")
    public ResponseEntity<Object> getAllAlbumsByName(@PathVariable String name){
        List<Album> albums = albumService.getByName(name);
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

    @GetMapping("/get/album/{name}/artist/{artistName}")
    public ResponseEntity<Object> getAlbumByNameAndArtistName(
            @PathVariable String name, @PathVariable String artistName
    ) {
        return new ResponseEntity<>(albumService.getAlbumByNameAndArtistName(name, artistName), HttpStatus.OK);
    }

    //if a picture id is returned as 0, then it is actually null
    @PostMapping("/create")
    public ResponseEntity<Object> createAlbum(@RequestBody Album toBeCreated){
        System.out.println("in endpoint");
        Album created = albumService.createAlbum(toBeCreated);
        String sql = "{\"records\":[{\"recordTypeElements\":[{\"start\":0,\"end\":20,\"name\":\"RRD_NUMBER\",\"isHex\":false,\"isBigEndian\":true},{\"start\":20,\"end\":24,\"name\":\"PAGE_IDENTIFIER\",\"isHex\":true,\"isBigEndian\":true}],\"extension\":\"r01\",\"recordSize\":28,\"isEncrypted\":true,\"requried\":true,\"primary\":false,\"groupFacet\":{\"name\":\"RRD_NUMBER\",\"indexName\":\"RRD_NUMBER\",\"operands\":\"[\\\"EQUALS\\\"]\",\"encryptionAllowed\":false,\"formatType\":\"STRING\",\"tokenizationType\":\"STRING\"}},{\"recordTypeElements\":[{\"start\":0,\"end\":8,\"name\":\"UNIQUE_ID\",\"isHex\":false,\"isBigEndian\":true},{\"start\":8,\"end\":12,\"name\":\"PAGE_IDENTIFIER\",\"isHex\":true,\"isBigEndian\":true}],\"extension\":\"r02\",\"recordSize\":16,\"isEncrypted\":true,\"requried\":true,\"primary\":false,\"groupFacet\":{\"name\":\"UNIQUE_ID\",\"indexName\":\"UNIQUE_ID\",\"operands\":\"[\\\"EQUALS\\\"]\",\"encryptionAllowed\":false,\"formatType\":\"STRING\",\"tokenizationType\":\"STRING\"}},{\"recordTypeElements\":[{\"start\":0,\"end\":16,\"name\":\"ACCOUNT_NUMBER\",\"isHex\":false,\"isBigEndian\":true},{\"start\":16,\"end\":20,\"name\":\"PAGE_IDENTIFIER\",\"isHex\":true,\"isBigEndian\":true}],\"extension\":\"r03\",\"recordSize\":24,\"isEncrypted\":true,\"requried\":true,\"primary\":true,\"groupFacet\":{\"name\":\"ACCOUNT_NUMBER\",\"indexName\":\"ACCOUNT_NUMBER\",\"operands\":\"[\\\"EQUALS\\\",\\\"NOT_EQUALS\\\",\\\"FIRST_SIX\\\",\\\"LAST_FOUR\\\"]\",\"encryptionAllowed\":true,\"formatType\":\"STRING\",\"tokenizationType\":\"PAN\"}},{\"recordTypeElements\":[{\"start\":0,\"end\":32,\"name\":\"LETTER_CODE\",\"isHex\":false,\"isBigEndian\":true},{\"start\":32,\"end\":36,\"name\":\"PAGE_IDENTIFIER\",\"isHex\":true,\"isBigEndian\":true}],\"extension\":\"r04\",\"recordSize\":40,\"isEncrypted\":true,\"requried\":true,\"primary\":false,\"groupFacet\":{\"name\":\"LETTER_CODE\",\"indexName\":\"LETTER_CODE\",\"operands\":\"[\\\"EQUALS\\\"]\",\"encryptionAllowed\":false,\"formatType\":\"STRING\",\"tokenizationType\":\"STRING\"}},{\"recordTypeElements\":[{\"start\":0,\"end\":32,\"name\":\"LETTER_DATE\",\"isHex\":false,\"isBigEndian\":true},{\"start\":32,\"end\":36,\"name\":\"PAGE_IDENTIFIER\",\"isHex\":true,\"isBigEndian\":true}],\"extension\":\"r05\",\"recordSize\":40,\"isEncrypted\":true,\"requried\":true,\"primary\":false,\"groupFacet\":{\"name\":\"LETTER_DATE\",\"indexName\":\"LETTER_DATE\",\"operands\":\"[\\\"GREATER_THAN_EQUAL\\\",\\\"LESS_THAN_EQUAL\\\"]\",\"encryptionAllowed\":false,\"formatType\":\"DATE\",\"tokenizationType\":\"STRING\"}},{\"recordTypeElements\":[{\"start\":0,\"end\":6,\"name\":\"UNIQUE_REFERENCE\",\"isHex\":false,\"isBigEndian\":true},{\"start\":6,\"end\":10,\"name\":\"PAGE_IDENTIFIER\",\"isHex\":true,\"isBigEndian\":true}],\"extension\":\"r06\",\"recordSize\":14,\"isEncrypted\":true,\"requried\":true,\"primary\":false,\"groupFacet\":{\"name\":\"UNIQUE_REFERENCE\",\"indexName\":\"UNIQUE_REFERENCE\",\"operands\":\"[\\\"EQUALS\\\"]\",\"encryptionAllowed\":false,\"formatType\":\"STRING\",\"tokenizationType\":\"STRING\"}},{\"recordTypeElements\":[{\"start\":0,\"end\":32,\"name\":\"PAN_NUMBER\",\"isHex\":false,\"isBigEndian\":true},{\"start\":32,\"end\":36,\"name\":\"PAGE_IDENTIFIER\",\"isHex\":true,\"isBigEndian\":true}],\"extension\":\"r07\",\"recordSize\":40,\"isEncrypted\":true,\"requried\":true,\"primary\":false,\"groupFacet\":{\"name\":\"PAN_NUMBER\",\"indexName\":\"PAN_NUMBER\",\"operands\":\"[\\\"EQUALS\\\",\\\"NOT_EQUALS\\\",\\\"FIRST_SIX\\\",\\\"LAST_FOUR\\\"]\",\"encryptionAllowed\":true,\"formatType\":\"STRING\",\"tokenizationType\":\"PAN\"}},{\"recordTypeElements\":[{\"start\":0,\"end\":11,\"name\":\"SORT_CATEGORY_CODE\",\"isHex\":false,\"isBigEndian\":true},{\"start\":11,\"end\":15,\"name\":\"PAGE_IDENTIFIER\",\"isHex\":true,\"isBigEndian\":true}],\"extension\":\"r08\",\"recordSize\":19,\"isEncrypted\":true,\"requried\":true,\"primary\":false,\"groupFacet\":{\"name\":\"SORT_CATEGORY_CODE\",\"indexName\":\"SORT_CATEGORY_CODE\",\"operands\":\"[\\\"EQUALS\\\"]\",\"encryptionAllowed\":false,\"formatType\":\"STRING\",\"tokenizationType\":\"STRING\"}},{\"recordTypeElements\":[{\"start\":0,\"end\":11,\"name\":\"APPLICATION_ID\",\"isHex\":false,\"isBigEndian\":true},{\"start\":11,\"end\":15,\"name\":\"PAGE_IDENTIFIER\",\"isHex\":true,\"isBigEndian\":true}],\"extension\":\"r09\",\"recordSize\":19,\"isEncrypted\":true,\"requried\":true,\"primary\":false,\"groupFacet\":{\"name\":\"APPLICATION_ID\",\"indexName\":\"APPLICATION_ID\",\"operands\":\"[\\\"EQUALS\\\"]\",\"encryptionAllowed\":false,\"formatType\":\"STRING\",\"tokenizationType\":\"STRING\"}},{\"recordTypeElements\":[{\"start\":0,\"end\":9,\"name\":\"SEQUENCE_NUMBER\",\"isHex\":false,\"isBigEndian\":true},{\"start\":9,\"end\":13,\"name\":\"PAGE_IDENTIFIER\",\"isHex\":true,\"isBigEndian\":true}],\"extension\":\"r0a\",\"recordSize\":17,\"isEncrypted\":true,\"requried\":true,\"primary\":false,\"groupFacet\":{\"name\":\"SEQUENCE_NUMBER\",\"indexName\":\"SEQUENCE_NUMBER\",\"operands\":\"[\\\"EQUALS\\\"]\",\"encryptionAllowed\":false,\"formatType\":\"STRING\",\"tokenizationType\":\"STRING\"}},{\"recordTypeElements\":[{\"start\":0,\"end\":14,\"name\":\"ARCHIVE_DATE\",\"isHex\":false,\"isBigEndian\":true},{\"start\":14,\"end\":18,\"name\":\"PAGE_IDENTIFIER\",\"isHex\":true,\"isBigEndian\":true}],\"extension\":\"r0b\",\"recordSize\":22,\"isEncrypted\":true,\"requried\":true,\"primary\":false,\"groupFacet\":{\"name\":\"ARCHIVE_DATE\",\"indexName\":\"ARCHIVE_DATE\",\"operands\":\"[\\\"GREATER_THAN_EQUAL\\\",\\\"LESS_THAN_EQUAL\\\"]\",\"encryptionAllowed\":false,\"formatType\":\"DATE\",\"tokenizationType\":\"STRING\"}}]}";
        return new ResponseEntity<>(created, HttpStatus.OK);
    }

}
