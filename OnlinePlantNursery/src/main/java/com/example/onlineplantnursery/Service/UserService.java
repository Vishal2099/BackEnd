package com.example.onlineplantnursery.Service;

import com.example.onlineplantnursery.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public User validateUser(String username, String password);
    public User addUser(User user);
    public User removeUser(User user);

    public List<User> getAllUser();
}
