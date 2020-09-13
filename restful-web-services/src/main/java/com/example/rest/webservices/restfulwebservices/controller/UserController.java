package com.example.rest.webservices.restfulwebservices.controller;

import com.example.rest.webservices.restfulwebservices.dao.UserDao;
import com.example.rest.webservices.restfulwebservices.entity.User;
import com.example.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class UserController {

    private UserDao userDao;

    @Autowired
    public UserController(UserDao inUserDao) {
        this.userDao = inUserDao;
    }

    @GetMapping(path = "/users")
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public EntityModel<User> getUserById(@PathVariable int id) {
        User user = userDao.findById(id);
        if (user == null) {
            throw new UserNotFoundException("User with id=" + id + " not found");
        }

        EntityModel<User> userEntityModel = EntityModel.of(user);
        WebMvcLinkBuilder webMvcLinkBuilder = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(this.getClass())
                        .getAllUsers());
        userEntityModel.add(webMvcLinkBuilder.withRel("all-users"));
        return userEntityModel;
    }

    @PostMapping(path = "/users")
    public ResponseEntity createUser(@Valid @RequestBody User user) {
        User savedUser = userDao.save(user);

        URI newUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        ResponseEntity responseEntity = ResponseEntity.created(newUri).build();
        return responseEntity;
    }

    @DeleteMapping(path = "/users/{id}")
    public void deleteUserById(@PathVariable int id) {
        User user = userDao.deleteById(id);
        if (user == null) {
            throw new UserNotFoundException("User with id=" + id + " not found");
        }
    }
}
