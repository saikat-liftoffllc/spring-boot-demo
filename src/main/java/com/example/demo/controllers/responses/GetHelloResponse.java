package com.example.demo.controllers.responses;

import org.immutables.value.Value;

@Value.Immutable
public interface GetHelloResponse {
    public String getMessage();
}
