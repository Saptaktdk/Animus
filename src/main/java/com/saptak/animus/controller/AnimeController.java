package com.saptak.animus.controller;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.saptak.animus.entity.AnimeItem;
import com.saptak.animus.service.AnimeService;
import com.saptak.animus.utils.AnimeItemResponse;
import com.saptak.animus.utils.ResponseStatusHandler;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
        //? Initialise wrapper storage
        ArrayList<Map<String, Object>> parsedAllAnimes = new ArrayList<>();

        //? Get All Animes
        List<AnimeItem> allAnimes = animeservice.findAllAnimes();

        //? Wrap all product items
        allAnimes.forEach((animeItem -> {
            Map<String, Object> parsedAnimeItem = AnimeItemResponse.parseAnimeItem(animeItem);
            parsedAllAnimes.add(parsedAnimeItem);
        }));

        //? Return response
        return ResponseStatusHandler.responseSuccessGetMany(parsedAllAnimes,Schema);
    }
    @GetMapping("/name")
    public ResponseEntity<Map<String,Object>> getAnimeByName(@RequestParam(value="name") String name) {
        //? Find anime by name
        Optional<AnimeItem> foundItem = animeservice.findAnimeByName(name);

        //? Handle if not found
        if(foundItem.isEmpty()) {
            return ResponseStatusHandler.responseErrorNameNotFound(name, Schema);
        }

        //? Add wrapper function to parse anime entity
        Map<String, Object> parsedAnimeItem = AnimeItemResponse.parseAnimeItem(foundItem.get());

        //? Return Response
        return  ResponseStatusHandler.responseSuccessGetNameOne(name, parsedAnimeItem,Schema);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getAnimeById(@PathVariable("id") ObjectId id) {
        //? Find anime by id
        Optional<AnimeItem> foundItem = animeservice.findAnimeById(id);

        //? Handle if not found
        if(foundItem.isEmpty()) {
            return ResponseStatusHandler.responseErrorNotFound(id, Schema);
        }

        //? Add wrapper function to parse anime entity
        Map<String, Object> parsedAnimeItem = AnimeItemResponse.parseAnimeItem(foundItem.get());

        //? Return Response
        return ResponseStatusHandler.responseSuccessGetOne(id, parsedAnimeItem, Schema);
    }
    @PostMapping("/add")
    public ResponseEntity<Map<String, Object>> addAnime(@RequestBody AnimeItem animeItem) {
        //? Add anime item into db
        Optional<AnimeItem> addedAnimeItem = animeservice.addAnime(animeItem);

        //? Handle if not added
        if(addedAnimeItem.isEmpty()) {
            return ResponseStatusHandler.responseErrorInternal();
        }

        //? Add wrapper function to parse anime entity
        Map<String, Object> parsedAnimeItem = AnimeItemResponse.parseAnimeItem(addedAnimeItem.get());

        //? return response
        return ResponseStatusHandler.responseSuccessAddOne(parsedAnimeItem,Schema);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> updateAnimeById(@PathVariable("id") ObjectId id, @RequestBody AnimeItem animeItem) {
        //? Check if anime item exists with the given id
        Update updateFields = new Update();

        //? Update the fields
        updateFields.set("name", animeItem.name);
        updateFields.set("description", animeItem.description);
        updateFields.set("rating", animeItem.rating);
        updateFields.set("link", animeItem.link);

        //? Update Query
        UpdateResult updateResult = mongoTemplate.update(AnimeItem.class)
                .matching(Criteria.where("_id").is(id))
                .apply(updateFields)
                .first();

        //! Error not found
        if(updateResult.getMatchedCount() == 0) {
            return ResponseStatusHandler.responseErrorNotFound(id,Schema);
        }

        //! Internal Server Error
        if(updateResult.getMatchedCount() == 0) {
            return ResponseStatusHandler.responseErrorInternal();
        }

        //? Set the id
        animeItem.id = id;

        //? Add wrapper function to parse entity
        Map<String, Object> parsedAnimeItem = AnimeItemResponse.parseAnimeItem(animeItem);

        //? Return response
        return ResponseStatusHandler.responseSuccessUpdateOne(id, parsedAnimeItem,Schema);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> deleteAnimeById(@PathVariable("id") ObjectId id) {
        //? Delete By Id
        DeleteResult deleteResult = mongoTemplate.remove(AnimeItem.class)
                .matching(Criteria.where("_id").is(id))
                .one();

        //! Error not found
        if(deleteResult.getDeletedCount() == 0) {
            return ResponseStatusHandler.responseErrorNotFound(id, Schema);
        }

        //? Return response
        return ResponseStatusHandler.responseSuccessDelete(id, Schema);
    }
}
