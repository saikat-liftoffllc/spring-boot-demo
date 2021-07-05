package com.example.demo.controllers;

import com.example.demo.controllers.responses.GetHelloResponse;
import com.example.demo.controllers.responses.ImmutableGetHelloResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;

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
    public Integer simpleFlux() throws Exception {
        System.out.println("simpleFlux:thread:" + Thread.currentThread().getName());
        Integer result = Mono.just(1)
                .subscribeOn(Schedulers.boundedElastic())
                .log()
                .delayElement(Duration.ofSeconds(30))
                .block();
        return result;
    }

    @GetMapping("completable-future")
    public void completableFutureTest() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000 * 60);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Result of the asynchronous computation";
        });
        System.out.println("completableFutureTest:thread:" + Thread.currentThread().getName());
        future.thenApply(result -> {
            System.out.println("completableFutureTest:thenApply:thread:" + Thread.currentThread().getName());
            return result;
        });
    }

}
