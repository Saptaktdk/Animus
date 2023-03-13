package com.saptak.animus.service;

import com.saptak.animus.entity.AnimeItem;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface AnimeService {
    List<AnimeItem> findAllAnimes();
    Optional<AnimeItem> findAnimeByName(String name);
    Optional<AnimeItem> findAnimeById(ObjectId id);
    Optional<AnimeItem> addAnime(AnimeItem animeItem);

}
