/*
 * This file is generated by jOOQ.
 */
package com.example.demo.tables.daos;


import com.example.demo.tables.Users;
import com.example.demo.tables.records.UsersRecord;

import java.util.List;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UsersDao extends DAOImpl<UsersRecord, com.example.demo.tables.pojos.Users, Integer> {

    /**
     * Create a new UsersDao without any configuration
     */
    public UsersDao() {
        super(Users.USERS, com.example.demo.tables.pojos.Users.class);
    }

    /**
     * Create a new UsersDao with an attached configuration
     */
    public UsersDao(Configuration configuration) {
        super(Users.USERS, com.example.demo.tables.pojos.Users.class, configuration);
    }

    @Override
    public Integer getId(com.example.demo.tables.pojos.Users object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.example.demo.tables.pojos.Users> fetchRangeOfId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Users.USERS.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.example.demo.tables.pojos.Users> fetchById(Integer... values) {
        return fetch(Users.USERS.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.example.demo.tables.pojos.Users fetchOneById(Integer value) {
        return fetchOne(Users.USERS.ID, value);
    }

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.example.demo.tables.pojos.Users> fetchRangeOfName(String lowerInclusive, String upperInclusive) {
        return fetchRange(Users.USERS.NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<com.example.demo.tables.pojos.Users> fetchByName(String... values) {
        return fetch(Users.USERS.NAME, values);
    }

    /**
     * Fetch records that have <code>email BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.example.demo.tables.pojos.Users> fetchRangeOfEmail(String lowerInclusive, String upperInclusive) {
        return fetchRange(Users.USERS.EMAIL, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>email IN (values)</code>
     */
    public List<com.example.demo.tables.pojos.Users> fetchByEmail(String... values) {
        return fetch(Users.USERS.EMAIL, values);
    }

    /**
     * Fetch a unique record that has <code>email = value</code>
     */
    public com.example.demo.tables.pojos.Users fetchOneByEmail(String value) {
        return fetchOne(Users.USERS.EMAIL, value);
    }
}