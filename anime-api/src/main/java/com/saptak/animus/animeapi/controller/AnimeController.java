package com.saptak.animus.animeapi.controller;

import com.saptak.animus.animeapi.entity.AnimeItem;
import com.saptak.animus.animeapi.service.AnimeService;
import org.apache.coyote.Response;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value="/api/v1/anime")
public class AnimeController {
    private final String Schema = "Anime";
    @Autowired
    private AnimeService animeservice;
    @Autowired
    private MongoTemplate mongoTemplate;
    @GetMapping("/all")
    public ResponseEntity<Map<String,Object>> getAllAnimes() {
        return  null;
    }
    @GetMapping("/{name}")
    public ResponseEntity<Map<String,Object>> getAnimeByName(@PathVariable("name") String name) {
        return  null;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getAnimeById(@PathVariable("id") ObjectId id) {
        return null;
    }
    @PostMapping("/add")
    public ResponseEntity<Map<String, Object>> addAnime(@RequestBody AnimeItem animeItem) {
        return null;
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> updateAnimeById(@PathVariable("id") ObjectId id, @RequestBody AnimeItem animeItem) {
        return null;
    }

    public ResponseEntity<Map<String, Object>> deleteAnimeById(@PathVariable("id") ObjectId id) {
        return null;
    }
}
