package com.example.onlineplantnursery.Controller;

import com.example.onlineplantnursery.Entity.User;
import com.example.onlineplantnursery.Repository.UserRepository;
import com.example.onlineplantnursery.Service.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("User")
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    UserRepository userRepository;

    @ApiOperation("Add a new  User")
    @PostMapping("/register")
    public ResponseEntity<User> regsiterUser(@Valid @RequestBody User user) {
        User userNew = userService.addUser(user);
        log.info("Added a new User");
        return new ResponseEntity<>(userNew, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<List<User>> loginUser(@Valid @RequestBody User user) {
        List<User> users = userRepository.findAll();
        for (User other : users) {
            log.info(String.valueOf(other));
            String name=other.getUsername();
            String pass= other.getPassword();
            if (name.equals(user.getUsername()) && pass.equals(user.getPassword())) {
                ResponseEntity<List<User>> listResponseEntity = new ResponseEntity<>(users, HttpStatus.ACCEPTED);
                return listResponseEntity;
            }
        }
        return new ResponseEntity<>(users, HttpStatus.FORBIDDEN);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<User>> getAllUser()
    {
        return ResponseEntity.ok(this.userService.getAllUser());

    }

    @DeleteMapping("/remove")
    public ResponseEntity<User> removeUser(@RequestBody User user) {
        User userRemoved = userService.removeUser(user);
        if (userRemoved != null)
            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>(user, HttpStatus.FORBIDDEN);
    }
}