package com.abdul.qurantracker.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@Document(collection = "users")
public class User {

    @Id
    private ObjectId id;
    private String userName;
    private String password;

    @DBRef
    // A list that holds all verseEntries written by this user
    private List<VerseEntry> verseEntry = new ArrayList<>();




}
