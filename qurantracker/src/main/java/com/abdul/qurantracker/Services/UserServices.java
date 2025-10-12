package com.abdul.qurantracker.Services;


import com.abdul.qurantracker.Entity.User;
import com.abdul.qurantracker.Entity.VerseEntry;
import com.abdul.qurantracker.Repository.UserRepository;
import com.abdul.qurantracker.Repository.VerseEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServices {

    @Autowired
    UserRepository userRepository;

    public void createUser(User user) {
        userRepository.save(user);
    }

    public List<User> getAll () {
        return userRepository.findAll();
    }

    public void deleteUser(ObjectId id) {
        userRepository.deleteById(id);
    }

    public Optional<User> findbyID(ObjectId id) {
        return userRepository.findById(id);
    }

}
