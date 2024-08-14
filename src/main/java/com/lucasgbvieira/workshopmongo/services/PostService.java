package com.lucasgbvieira.workshopmongo.services;

import com.lucasgbvieira.workshopmongo.domain.Post;
import com.lucasgbvieira.workshopmongo.repository.PostRepository;
import com.lucasgbvieira.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findByID(String id) {
        Optional<Post> post = repository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}
