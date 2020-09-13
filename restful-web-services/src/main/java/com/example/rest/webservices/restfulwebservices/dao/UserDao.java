package com.example.rest.webservices.restfulwebservices.dao;

import com.example.rest.webservices.restfulwebservices.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDao {
    private static List<User> USERS = new ArrayList<>();

    static {
        USERS.add(new User(1, "Nitheesh", new Date()));
        USERS.add(new User(2, "Krishna", new Date()));
    }

    public static int totalUsers() {
        return USERS.size();
    }

    public List<User> findAll() {
        return USERS;
    }

    public User save(User inUser) {
        if (inUser.getId() == null) {
            inUser.setId(UserDao.totalUsers()+1);
        }
        USERS.add(inUser);
        return inUser;
    }

    public User findById(int inId) {
        for (User user: USERS) {
            if (user.getId() == inId) {
                return user;
            }
        }
        return null;
    }

    public User deleteById(int inId) {
        Iterator<User> iterator = USERS.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == inId) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}
