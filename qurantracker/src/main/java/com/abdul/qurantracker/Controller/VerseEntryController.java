package com.abdul.qurantracker.Controller;


import com.abdul.qurantracker.Entity.VerseEntry;
import com.abdul.qurantracker.Services.UserServices;
import com.abdul.qurantracker.Services.VerseEntryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/verse")
public class VerseEntryController {
    @Autowired
    VerseEntryServices verseEntryServices;

    @PostMapping
    public Boolean saveEntry(@RequestBody VerseEntry myEntry) {
        verseEntryServices.saveEntry(myEntry);
        return true;
    }

    @GetMapping
    public List<VerseEntry> getAll() {
       return verseEntryServices.getALl();

    }

    @DeleteMapping
    public Boolean deleteEntry() {
        verseEntryServices.deleteEntry();
        return true;
    }


//
//    public List<VerseEntry> updateEntryby() {
//
//    }

}

