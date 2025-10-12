package com.abdul.qurantracker.Controller;

import com.abdul.qurantracker.Entity.User;
import com.abdul.qurantracker.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserServices userServices;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
       userServices.createUser(user);
       return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public List<User> getAll() {
        return userServices.getAll();
    }
}
