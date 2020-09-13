package com.example.rest.webservices.restfulwebservices.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel(description = "Details of the user")
//@JsonIgnoreProperties(value = {"birthDate"})    // Static filtering
@JsonFilter("UserFilter2")  // Dynamic filtering, filter defined inside controller
public class UserFiltered {

    private Integer id;

    @Size(min=2)
    @ApiModelProperty(notes = "Name must have at least 2 characters")
    private String name;

    @Past
    @ApiModelProperty(notes = "Birth date should be in the past")
    @JsonIgnore   // Static Filtering
    private Date birthDate;

    public UserFiltered() {
    }

    public UserFiltered(Integer id, String name, Date birthDate) {
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
}
