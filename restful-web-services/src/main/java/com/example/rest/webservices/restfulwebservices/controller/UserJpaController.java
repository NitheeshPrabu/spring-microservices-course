package com.example.rest.webservices.restfulwebservices.controller;

import com.example.rest.webservices.restfulwebservices.entity.Post;
import com.example.rest.webservices.restfulwebservices.repository.PostRepository;
import com.example.rest.webservices.restfulwebservices.repository.UserRepository;
import com.example.rest.webservices.restfulwebservices.entity.User;
import com.example.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class UserJpaController {

    private UserRepository userRepository;
    private PostRepository postRepository;

    @Autowired
    public UserJpaController(UserRepository inUserRepository, PostRepository inPostRepository) {
        this.userRepository = inUserRepository;
        this.postRepository = inPostRepository;
    }

    @GetMapping(path = "/jpa/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/jpa/users/{id}")
    public EntityModel<User> getUserById(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new UserNotFoundException("User with id=" + id + " not found");
        }

        EntityModel<User> userEntityModel = EntityModel.of(user.get());
        WebMvcLinkBuilder webMvcLinkBuilder = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(this.getClass())
                        .getAllUsers());
        userEntityModel.add(webMvcLinkBuilder.withRel("all-users"));
        return userEntityModel;
    }

    @PostMapping(path = "/jpa/users")
    public ResponseEntity createUser(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);

        URI newUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        ResponseEntity responseEntity = ResponseEntity.created(newUri).build();
        return responseEntity;
    }

    @DeleteMapping(path = "/jpa/users/{id}")
    public void deleteUserById(@PathVariable int id) {
        // auto throws exception
        userRepository.deleteById(id);
    }

    @GetMapping(path = "/jpa/users/{id}/posts")
    public CollectionModel<Post> getUserPostsById(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new UserNotFoundException("User with id=" + id + " not found");
        }

        CollectionModel<Post> postsCollectionModel = CollectionModel.of(user.get().getPosts());
        WebMvcLinkBuilder webMvcLinkBuilder = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(this.getClass())
                        .getAllUsers());
        postsCollectionModel.add(webMvcLinkBuilder.withRel("all-users"));
        return postsCollectionModel;
    }

    @PostMapping(path = "/jpa/users/{id}/posts")
    public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post post) {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
            throw new UserNotFoundException("User with id=" + id + " not found");
        }

        User user = userOptional.get();
        post.setUser(user);
        postRepository.save(post);

        URI newUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(post.getId())
                .toUri();
        ResponseEntity responseEntity = ResponseEntity.created(newUri).build();
        return responseEntity;
    }
}
