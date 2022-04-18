package com.Elysian.SpringBootExercise.controller;

import com.Elysian.SpringBootExercise.controller.payload.News;
import com.Elysian.SpringBootExercise.controller.payload.NewsResponse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/current")
public class CurrentAPIController {

    private String apiToken = "OYn3m5RxvgdAAHPE-KFluHtUassbNW90z8OipGNoonAaaUKI";
    private String apiUrl = "https://api.currentsapi.services/v1/search";


    @Cacheable(value="news", key="'newsCacheKey'+#query")
    @GetMapping("/news")
    public ResponseEntity<?> getNews(@RequestParam("query") String query){

        //create new request with api token and api url
        RequestEntity<?> requestEntity = RequestEntity.get(apiUrl + "?keywords=" + query)
                                                      .accept(MediaType.ALL)
                                                      .header("Authorization", apiToken)
                                                      .build();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<NewsResponse> responseEntity = restTemplate.exchange(requestEntity, NewsResponse.class);

        return ResponseEntity.ok(responseEntity.getBody());
    }



}
