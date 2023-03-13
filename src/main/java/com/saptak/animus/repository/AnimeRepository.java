package com.saptak.animus.repository;

import com.saptak.animus.entity.AnimeItem;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface AnimeRepository extends MongoRepository<AnimeItem, ObjectId> {
    Optional<AnimeItem> findByName(String name);
}
