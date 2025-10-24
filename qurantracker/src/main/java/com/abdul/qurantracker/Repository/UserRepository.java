package com.abdul.qurantracker.Repository;

import com.abdul.qurantracker.Entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    Optional<User> findUserByUserName(String userName);

}
