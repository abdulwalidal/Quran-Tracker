package com.abdul.qurantracker.Services;

import com.abdul.qurantracker.Entity.User;
import com.abdul.qurantracker.Repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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

    public User getUserbyUsername(String userName) {
        return userRepository.findUserByUserName(userName);
    }


    public User updateUser(ObjectId id, User newEntry) {
        User old = getUserByObjectId(id);

        if (newEntry.getUserName() != null && !newEntry.getUserName().isEmpty()) {
            old.setUserName(newEntry.getUserName());
        }
        if (newEntry.getPassword() != null && !newEntry.getPassword().isEmpty()) {
            old.setPassword(newEntry.getPassword());
        }
        return userRepository.save(old);
    }
//
//    public void deleteUserbyID(ObjectId id, String userName) {
//        User user = userRepository.findUserByUserName(userName);
//
//    }
}

