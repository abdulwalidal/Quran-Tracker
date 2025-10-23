package com.abdul.qurantracker.Services;

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

    public void saveEntry(VerseEntry myEntry) {
        verseEntryRepository.save(myEntry);
    }

    public List<VerseEntry> getALl () {
        return verseEntryRepository.findAll();
    }


    public void deleteEntry() {
        verseEntryRepository.deleteAll();
    }
}
