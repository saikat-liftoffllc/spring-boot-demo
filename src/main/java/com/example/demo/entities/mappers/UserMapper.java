package com.example.demo.entities.mappers;

import com.example.demo.entities.User;
import com.example.demo.tables.records.UsersRecord;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper mapper = Mappers.getMapper(UserMapper.class);
    User toUser(UsersRecord userRecord);
}
