package com.john.job_connect.repository;

import com.john.job_connect.model.Post;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.RequiredArgsConstructor;

import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class SearchRepoImpl implements SearchRepository{

    private final MongoClient client;
    private final MongoConverter converter;
    @Override
    public List<Post> findByText(String text) {
        final List<Post> posts = new ArrayList<>();

        MongoDatabase database = client.getDatabase("JobListings");
        MongoCollection<Document> collection = database.getCollection("jobPosts");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
                new Document("$search",
                        new Document("text",
                                new Document("query", text)
                                        .append("path", Arrays.asList("skills_required","company", "location", "title")))),
                new Document("$sort", new Document("experience_required", 1L)),
                new Document("$limit", 10L)));

        result.forEach(doc -> posts.add(converter.read(Post.class, doc)));
        return posts;
    }

}
