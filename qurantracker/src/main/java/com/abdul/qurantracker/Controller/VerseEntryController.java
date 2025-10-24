package com.abdul.qurantracker.Controller;


import com.abdul.qurantracker.Entity.VerseEntry;
import com.abdul.qurantracker.Services.UserServices;
import com.abdul.qurantracker.Services.VerseEntryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/verse")
public class VerseEntryController {
    @Autowired
    VerseEntryServices verseEntryServices;

    @PostMapping("/{userName}")
    public ResponseEntity<?> saveEntry(@RequestBody VerseEntry myEntry, @PathVariable String userName ) {
         try { verseEntryServices.saveEntry(myEntry, userName);
             return ResponseEntity.ok("Verse added Successfully"); }
         catch(Exception e) {
             return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error" + e.getMessage());
        }
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




}

