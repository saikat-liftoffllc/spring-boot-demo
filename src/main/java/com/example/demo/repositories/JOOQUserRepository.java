package com.example.demo.repositories;

import com.example.demo.controllers.requests.CreateUserRequest;
import com.example.demo.entities.User;
import com.example.demo.entities.mappers.UserMapper;
import com.example.demo.tables.records.UsersRecord;
import org.jooq.DSLContext;
import org.jooq.exception.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import static com.example.demo.Tables.USERS;

@Repository
public class JOOQUserRepository implements UserRepository {
    private final Logger logger = LoggerFactory.getLogger(JOOQUserRepository.class);
    private final DSLContext jooq;

    public JOOQUserRepository(DSLContext jooq) {
        this.jooq = jooq;
    }

    @Override
    public User create(CreateUserRequest createUserRequest) {
        logger.info("Creating user" + createUserRequest);
        UsersRecord userRecord = jooq
                .insertInto(USERS)
                .set(USERS.NAME, createUserRequest.getName())
                .set(USERS.EMAIL, createUserRequest.getEmail())
                .returning()
                .fetchOne();
        return UserMapper.mapper.toUser(userRecord);
    }

    @Override
    public User findById(Integer userId) {
        UsersRecord record = jooq.selectFrom(USERS).where(USERS.ID.equal(userId)).fetchOne();
        if (record.equals(null)) {
            throw new DataAccessException("User record not found with id: " + userId);
        }
        return UserMapper.mapper.toUser(record);
    }
}
