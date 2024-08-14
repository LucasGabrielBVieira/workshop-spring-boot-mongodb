package com.lucasgbvieira.workshopmongo.config;

import com.lucasgbvieira.workshopmongo.domain.Post;
import com.lucasgbvieira.workshopmongo.domain.User;
import com.lucasgbvieira.workshopmongo.dto.AuthorDTO;
import com.lucasgbvieira.workshopmongo.dto.CommentDTO;
import com.lucasgbvieira.workshopmongo.repository.PostRepository;
import com.lucasgbvieira.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        postRepository.deleteAll();
        userRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(
                null,
                sdf.parse("21/03/2024"),
                "Partiu viagem!",
                "Vou para São Paulo amanhã!",
                new AuthorDTO(maria));

        Post post2 = new Post(
                null,
                sdf.parse("22/03/2024"),
                "Cheguei!",
                "Foi muito cansativo...",
                new AuthorDTO(maria));

        CommentDTO comment1 = new CommentDTO("Boa viagem, brother!", sdf.parse("21/03/2024"), new AuthorDTO(alex));
        CommentDTO comment2 = new CommentDTO("Aproveite", sdf.parse("21/03/2024"), new AuthorDTO(bob));
        CommentDTO comment3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("21/03/2024"), new AuthorDTO(bob));

        post1.getComments().addAll(Arrays.asList(comment1, comment3));
        post2.getComments().add(comment2);


        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
}
