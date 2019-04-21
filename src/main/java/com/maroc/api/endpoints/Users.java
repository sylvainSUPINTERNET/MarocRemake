package com.maroc.api.endpoints;

import com.maroc.api.dao.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
public class Users {

    final UsersRepository usersRepository;

    public Users(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    };

    //override le nom des routes mais en réalité ces endpoints existe deja via JPA repository
    @GetMapping(path = "/users")
    public List getUsers(){
       return usersRepository.findAll();
    }

    //@ExceptionHandler(Exception.class)
    @GetMapping(path = "/users/{id}")
    public Optional<com.maroc.api.entities.Users> getUsersById(@PathVariable long id){
        Optional <com.maroc.api.entities.Users> optional= usersRepository.findById(id);
        optional.ifPresent(user -> {
            System.out.println(user);
        });
        return optional;
    }



}


