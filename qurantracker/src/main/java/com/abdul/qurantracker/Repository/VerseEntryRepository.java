package com.abdul.qurantracker.Repository;

import com.abdul.qurantracker.Entity.VerseEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VerseEntryRepository extends MongoRepository<VerseEntry, ObjectId> {
}



