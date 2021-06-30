package com.example.demo.controllers;

import com.example.demo.controllers.responses.GetHelloResponse;
import com.example.demo.controllers.responses.ImmutableGetHelloResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String getHello() {
        return "Hello World";
    }

    @GetMapping("/hello/{name}")
    public GetHelloResponse getHello(@PathVariable String name) {
        ImmutableGetHelloResponse response = ImmutableGetHelloResponse.builder()
                .message(String.format("Hello %s", name))
                .build();
        return response;
    }
}
