package com.abdul.qurantracker.Services;

import com.abdul.qurantracker.Entity.User;
import com.abdul.qurantracker.Entity.VerseEntry;
import com.abdul.qurantracker.Repository.VerseEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerseEntryServices {

    @Autowired
    VerseEntryRepository verseEntryRepository;
    @Autowired
    UserServices userService;


    // Before saving any entry, the user must exist — so we need to find that user first.
    public void saveEntry(VerseEntry myEntry, String userName) {
        // basic validation
        if (myEntry == null) {
            throw new RuntimeException("Entry is null");
        }
        if (myEntry.getSurah() == null || myEntry.getSurah().isEmpty()) {
            throw new RuntimeException("surah is required");
        }
        if (myEntry.getVerseNo() == null || myEntry.getVerseNo().isEmpty()) {
            throw new RuntimeException("verseNo is required");
        }

        User user = userService.getUserbyUsername(userName);
        if(user==null) {
            throw new RuntimeException("User not found: " + userName);
        }
        VerseEntry verseEntry = verseEntryRepository.save(myEntry);
        user.getVerseEntry().add(verseEntry);
        userService.createUser(user);
    }

    public VerseEntry updateVerseEntry(VerseEntry newEntry, ObjectId id) {
        VerseEntry oldVerseEntry = verseEntryRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        if(newEntry.getSurah()!=null && !newEntry.getSurah().isEmpty()) {
            oldVerseEntry.setSurah(newEntry.getSurah());
        }

        if(newEntry.getVerseNo()!=null && !newEntry.getVerseNo().isEmpty()) {
         oldVerseEntry.setVerseNo(newEntry.getVerseNo());
        }
        return verseEntryRepository.save(oldVerseEntry);

    }

    public List<VerseEntry> getALl () {
        return verseEntryRepository.findAll();
    }

    public void deleteEntry() {
        verseEntryRepository.deleteAll();
    }


}
