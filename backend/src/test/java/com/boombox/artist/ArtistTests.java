package com.boombox.artist;

import com.boombox.enitity.response.ArtistResponse;
import com.boombox.service.ArtistService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringJUnitConfig
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ArtistTests {
    @Autowired
    private ArtistService artistService;

    @Autowired
    private TestRestTemplate restTemplate;

    private String rootUrl = "/boombox/artist";
    @Test
    public void testGetById(){
        String url = "/get/id/{id}";
        ResponseEntity<ArtistResponse> res = restTemplate.getForEntity(
                rootUrl + url, ArtistResponse.class, 1);

        ArtistResponse expected = new ArtistResponse(
                1, "TRAVIS SCOTT", "Travis Scott", 0, 0);
        assertThat(res.getBody()).usingRecursiveComparison().isEqualTo(expected);
        assertThat(res.getStatusCode()).usingRecursiveComparison().isEqualTo(HttpStatus.OK);

    }

    @Test
    public void testGetByName(){
        String url = "/get/name/{name}";
        ResponseEntity<ArtistResponse> res = restTemplate.getForEntity(
                rootUrl + url, ArtistResponse.class, "arcTic MonkEys");

        ArtistResponse expected = new ArtistResponse(
                2, "ARCTIC MONKEYS", "Arctic Monkeys", 0, 0);
        assertThat(res.getBody()).usingRecursiveComparison().isEqualTo(expected);

    }



    @Test
    public void createAndDeleteArtist(){
        String artist = "Test artist 1";
        String url = "/create/name/"+artist;
        // url, request body, class
        ResponseEntity<ArtistResponse> actual = restTemplate.postForEntity(rootUrl + url, null, ArtistResponse.class);
        ArtistResponse expected = new ArtistResponse();
        expected.setName(artist);
        expected.setArtistIndex(artist.toUpperCase());
        expected.setIsDeleted(0);

        assertThat(expected.getArtistIndex()).isEqualTo(actual.getBody().getArtistIndex());
        assertThat(expected.getName()).isEqualTo(actual.getBody().getName());
        assertThat(expected.getIsDeleted()).isEqualTo(actual.getBody().getIsDeleted());

    }

}
