package com.lennys.service;

import com.lennys.dao.Dao;
import com.lennys.dao.JDBCUserDAO;
import com.lennys.exception.DBException;
import com.lennys.model.people.User;



public class UserService {
    private static UserService instance;

    Dao<User,String> users;

    private UserService(Dao<User,String> us){ users = us;}

    public static UserService getInstance(){
        if(null == instance)
            instance = new UserService(new JDBCUserDAO());

        return instance;
    }

    public boolean doesUsernameExist(String username){
        // O(n) time complexity O(1) space complexity
        return findUserByUsername(username) != null;
    }

    public User findUserByUsername(String username){

        try {
            return users.read(username);
        } catch (DBException e) {
            e.printStackTrace();

        }
        return null;

    }

    public void makeUser(String username, String password, String phoneNumber, String email) {

        User newUser = new User(username,password,phoneNumber,email);

    }

    public void register(String username, String password, String phoneNumber, String email) throws DBException {
        User newUser = new User(username,password,phoneNumber,email);
        users.create(newUser);
    }
    public void hire() {}
}
