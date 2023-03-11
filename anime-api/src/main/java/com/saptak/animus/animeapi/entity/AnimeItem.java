package com.saptak.animus.animeapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "anime")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimeItem {
    @Id
    @Field( name = "_id")
    public ObjectId id;

    @Field( name = "name")
    public String name;

    @Field( name = "description")
    public String description;

    @Field( name = "rating")
    public Float rating;

    @Field( name = "link")
    public String link;
}
