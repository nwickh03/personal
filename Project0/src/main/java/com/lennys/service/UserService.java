package com.lennys.service;

import com.lennys.model.people.User;
import com.lennys.util.LennyLinkedListSet;

public class UserService {
    private static LennyLinkedListSet<User> users; // Stores a working copy of the user table   TODO: Pull from DB

    public boolean doesUsernameExist(String username){
        // O(n) time complexity O(1) space complexity
        return findUserByUsername(username) != null;
    }

    public User findUserByUsername(String username){
        return null;
    }


    // TODO: Ensure duplicates do not exist, while minimizing calls to doesUsernameExist method.
    public void makeUser(String username, String password, String phoneNumber, String email) {

        User newUser = new User(username,password,phoneNumber,email);

    }
}
