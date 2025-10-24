package com.abdul.qurantracker.Controller;

import com.abdul.qurantracker.Entity.User;
import com.abdul.qurantracker.Services.UserServices;
import jakarta.annotation.security.PermitAll;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable ObjectId id) {
        userServices.deleteUser(id);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable ObjectId id) {
        return userServices.getUserByObjectId(id);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable ObjectId id, @RequestBody User user) {
        userServices.updateUser(id, user);
        return new ResponseEntity<>(HttpStatus.OK);
    }







}
