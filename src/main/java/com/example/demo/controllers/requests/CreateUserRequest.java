package com.example.demo.controllers.requests;

import org.immutables.value.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Value.Immutable
public interface CreateUserRequest {
    @Size(min = 3, max = 30)
    String getName();

    @NotEmpty
    @Email
    String getEmail();
}
