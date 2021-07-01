package com.example.demo.entities;

import org.immutables.value.Value;

@Value.Immutable
public interface User {
    Integer getId();
    String getName();
    String getEmail();
}
