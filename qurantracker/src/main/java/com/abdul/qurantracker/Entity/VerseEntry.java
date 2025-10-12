package com.abdul.qurantracker.Entity;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "verse_entries")
public class VerseEntry {

    private String Surah;
    private String verseNo;
    private boolean Memorized;


}


