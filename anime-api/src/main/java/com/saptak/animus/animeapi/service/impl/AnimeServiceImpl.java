package com.saptak.animus.animeapi.service.impl;

import com.saptak.animus.animeapi.entity.AnimeItem;
import com.saptak.animus.animeapi.repository.AnimeRepository;
import com.saptak.animus.animeapi.service.AnimeService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimeServiceImpl implements AnimeService {
    @Autowired
    private AnimeRepository animeRepository;
    @Override
    public List<AnimeItem> findAllAnimes() {
        return animeRepository.findAll();
    }

    @Override
    public Optional<AnimeItem> findAnimeByName(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<AnimeItem> findAnimeById(ObjectId id) {
        return animeRepository.findById(id);
    }

    @Override
    public Optional<AnimeItem> addAnime(AnimeItem animeItem) {
        return Optional.of(animeRepository.save(animeItem));
    }

}
