package model;

import schema.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Created by JianFa on 2017/7/15.
 */
public class UserList {

    private Map<String, User> userMap;

    public UserList () {
        userMap = new HashMap<>();
    }

    public void register(User user) throws IOException {
        if(userMap.containsKey(user.getId())) throw new IOException("There is already a user that has same id.");
        userMap.put(user.getId(), user);
    }

    public User getUserById(String userId) {
        if(!userMap.containsKey(userId)) throw new NoSuchElementException("User id is incorrect.");
        return userMap.get(userId);
    }
}
