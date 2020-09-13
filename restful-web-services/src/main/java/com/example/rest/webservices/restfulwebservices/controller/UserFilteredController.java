package com.example.rest.webservices.restfulwebservices.controller;

import com.example.rest.webservices.restfulwebservices.dao.UserFilteredDao;
import com.example.rest.webservices.restfulwebservices.entity.UserFiltered;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/filtered")
public class UserFilteredController {

    private UserFilteredDao userFilteredDao;

    @Autowired
    public UserFilteredController(UserFilteredDao inUserDao) {
        this.userFilteredDao = inUserDao;
    }

//    @GetMapping(path = "/users")
//    public List<UserFiltered> getFilteredUsers() {
//        return userFilteredDao.findAll();
//    }

//    @GetMapping(path = "/user1Filtered")
//    public MappingJacksonValue getFilteredUser1() {
//        UserFiltered user = userFilteredDao.findById(1);
//
//        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name");
//        FilterProvider filters = new SimpleFilterProvider().addFilter("UserFilter1", filter);
//
//        MappingJacksonValue mapping = new MappingJacksonValue(user);
//        mapping.setFilters(filters);
//
//        return mapping;
//    }

    @GetMapping(path = "/usersListFiltered")
    public MappingJacksonValue getFilteredUsersList() {
        List<UserFiltered> users = userFilteredDao.findAll();

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name");
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserFilter2", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(users);
        mapping.setFilters(filters);

        return mapping;
    }
}
