package com.lucasgbvieira.workshopmongo.repository;

import com.lucasgbvieira.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {

}
