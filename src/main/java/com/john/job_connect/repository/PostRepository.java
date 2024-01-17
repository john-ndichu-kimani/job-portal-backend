package com.john.job_connect.repository;

import com.john.job_connect.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post,Long> {


}
