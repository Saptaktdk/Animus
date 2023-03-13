package com.saptak.animus.utils;

import com.saptak.animus.entity.AnimeItem;
import java.util.HashMap;
import java.util.Map;

public class AnimeItemResponse {
    //? Wrapper function to parse product entity
    public static Map<String, Object> parseAnimeItem(AnimeItem animeItem) {
        Map<String, Object> animeResponse = new HashMap<>();
        animeResponse.put("id", animeItem.id.toString());
        animeResponse.put("name", animeItem.name);
        animeResponse.put("description", animeItem.description);
        animeResponse.put("rating", Math.round(animeItem.rating*10)/10F);
        animeResponse.put("link", animeItem.link);

        return animeResponse;
    }
}
