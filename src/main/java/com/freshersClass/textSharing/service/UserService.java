package com.freshersClass.textSharing.service;

import java.util.List;

import com.freshersClass.textSharing.entity.User;

public interface UserService {

    /**
     *
     * @param user
     * @return created user instance
     */
    User saveUser(User user);

    /**
     *
     * @return all created user
     */
    List<User> getAllUser();

    /**
     *
     * @param username
     * @return user instance
     */
    User getUserByUsername(String username);

}
