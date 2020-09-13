package com.example.rest.webservices.restfulwebservices.dao;

import com.example.rest.webservices.restfulwebservices.entity.UserFiltered;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserFilteredDao {
    private static List<UserFiltered> USERS = new ArrayList<>();

    static {
        USERS.add(new UserFiltered(1, "Nitheesh", new Date()));
        USERS.add(new UserFiltered(2, "Krishna", new Date()));
    }

    public static int totalUsers() {
        return USERS.size();
    }

    public List<UserFiltered> findAll() {
        return USERS;
    }

    public UserFiltered save(UserFiltered inUser) {
        if (inUser.getId() == null) {
            inUser.setId(UserFilteredDao.totalUsers()+1);
        }
        USERS.add(inUser);
        return inUser;
    }

    public UserFiltered findById(int inId) {
        for (UserFiltered user: USERS) {
            if (user.getId() == inId) {
                return user;
            }
        }
        return null;
    }

    public UserFiltered deleteById(int inId) {
        Iterator<UserFiltered> iterator = USERS.iterator();
        while (iterator.hasNext()) {
            UserFiltered user = iterator.next();
            if (user.getId() == inId) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}
