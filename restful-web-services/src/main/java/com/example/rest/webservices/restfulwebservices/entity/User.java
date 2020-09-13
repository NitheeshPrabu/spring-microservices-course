package com.example.rest.webservices.restfulwebservices.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ApiModel(description = "Details of the user")
@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min=2)
    @ApiModelProperty(notes = "Name must have at least 2 characters")
    private String name;

    @Past
    @ApiModelProperty(notes = "Birth date should be in the past")
    private Date birthDate;

    @OneToMany(mappedBy = "user")
    List<Post> posts = new ArrayList<>();

    public User() {
    }

    public User(Integer id, @Size(min = 2) String name, @Past Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer inId) {
        this.id = inId;
    }

    public String getName() {
        return name;
    }

    public void setName(String inName) {
        this.name = inName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date inBirthDate) {
        this.birthDate = inBirthDate;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void addPost(Post post) {
        this.posts.add(post);
    }

    public void removePost(Post post) {
        this.posts.remove(post);
    }
}
