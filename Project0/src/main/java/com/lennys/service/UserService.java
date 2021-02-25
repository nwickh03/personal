package com.lennys.service;

import com.lennys.model.people.User;

public class UserService {


    private static User[] users = new User[5];
    // TODO: potential risk of overriting users if index is not incremented and decremented carefully
    private static int currentIndex = -1;


    public boolean doesUsernameExist(String username){
        // O(n) time complexity O(1) space complexity
        return findUserByUsername(username) != null;
    }

    public User findUserByUsername(String username){
        // O(n) time complexity O(1) space complexity
        if(currentIndex > -1) {
            for (int i = 0; i <= currentIndex; i++) {
                if (users[i].getUsername().equals(username)) {
                    return users[i];
                }
            }
        }
        return null;
    }


    // TODO: Ensure duplicates do not exist, while minimizing calls to doesUsernameExist method.
    public boolean makeUser(String username, String password, String phoneNumber, String email){
        if(!doesUsernameExist(username)){
            if((currentIndex + 1) < users.length){
                if(users[currentIndex+1] == null){
                    users[++currentIndex] = new User(username, password, phoneNumber, email);
                    return true;
                }
            }
        } else {
            System.out.println("user already exists");
        }
        return false;
    }

}
