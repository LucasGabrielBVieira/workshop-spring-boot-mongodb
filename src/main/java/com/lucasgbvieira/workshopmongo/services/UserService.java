package com.lucasgbvieira.workshopmongo.services;

import com.lucasgbvieira.workshopmongo.domain.User;
import com.lucasgbvieira.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

}
