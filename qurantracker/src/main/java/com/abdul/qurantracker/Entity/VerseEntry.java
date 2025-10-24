package com.abdul.qurantracker.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "verse_entries")
@Data
@NoArgsConstructor
public class VerseEntry {
    @Id
    private ObjectId id;
    private String surah;
    private String verseNo;
    private boolean memorized;
}