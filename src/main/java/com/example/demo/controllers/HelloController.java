package com.example.demo.controllers;

import com.example.demo.controllers.responses.GetHelloResponse;
import com.example.demo.controllers.responses.ImmutableGetHelloResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@RestController
public class HelloController {
    @GetMapping("/controller-info")
    public String getControllerInfo() {
        // This is to just check if HelloController gets instantiated only once.
        return this.toString();
    }

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

    @GetMapping("simple-flux")
    public String simpleFlux() throws Exception{
        Flux.just(1, 2, 3)
                .subscribeOn(Schedulers.parallel())
                .log()
                .flatMap(n -> Flux.just(n * 2))
                .log()
                .subscribe(n->System.out.println(n));
        return "Done!!";
    }
}
