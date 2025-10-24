package com.abdul.qurantracker.Services;

import com.abdul.qurantracker.Entity.User;
import com.abdul.qurantracker.Repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public void createUser(User user) {
        userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public void deleteUser(ObjectId id) {
        userRepository.deleteById(id);
    }

    public User getUserByObjectId(ObjectId id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public User updateUser(ObjectId id, User newEntry) {
        User old = getUserByObjectId(id);

        if (newEntry.getUserName() != null && !newEntry.getUserName().isEmpty()) {
            old.setUserName(newEntry.getUserName());
        }
        if (newEntry.getPassword() != null && !newEntry.getPassword().isEmpty()) {
            old.setPassword(newEntry.getPassword());
        }
        if (newEntry.getPassword() != null && !newEntry.getPassword().isEmpty()) {
            old.setPassword(newEntry.getPassword());
        }

        return userRepository.save(old);;
    }
}


