package com.example.demo.entities.mappers;

import com.example.demo.entities.ImmutableUser;
import com.example.demo.entities.ImmutableUser.Builder;
import com.example.demo.entities.User;
import com.example.demo.tables.records.UsersRecord;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-08-08T01:19:20+0530",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.0.2.jar, environment: Java 11.0.11 (Amazon.com Inc.)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public User toUser(UsersRecord userRecord) {
        if ( userRecord == null ) {
            return null;
        }

        Builder user = ImmutableUser.builder();

        user.id( userRecord.getId() );
        user.name( userRecord.getName() );
        user.email( userRecord.getEmail() );

        return user.build();
    }
}
