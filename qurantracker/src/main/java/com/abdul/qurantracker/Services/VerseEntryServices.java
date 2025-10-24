package com.abdul.qurantracker.Services;

import com.abdul.qurantracker.Entity.User;
import com.abdul.qurantracker.Entity.VerseEntry;
import com.abdul.qurantracker.Repository.VerseEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VerseEntryServices {

    @Autowired
    VerseEntryRepository verseEntryRepository;
    @Autowired
    UserServices userService;


    // Before saving any entry, the user must exist — so we need to find that user first.
    public void saveEntry(VerseEntry myEntry, String userName) {
        User user = userService.getUserbyUsername(userName);
        if(user==null) {
            throw new RuntimeException("User not found" + userName);
        }
        VerseEntry verseEntry = verseEntryRepository.save(myEntry);
        user.getVerseEntry().add(verseEntry);
        userService.createUser(user);
    }


    public List<VerseEntry> getALl () {
        return verseEntryRepository.findAll();
    }

    public void deleteEntry() {
        verseEntryRepository.deleteAll();
    }


}
