package com.saptak.animus.animeapi.repository;

import com.saptak.animus.animeapi.entity.AnimeItem;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnimeRepository extends MongoRepository<AnimeItem, ObjectId> {
}
