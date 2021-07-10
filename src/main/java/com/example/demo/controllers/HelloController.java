package com.example.demo.controllers;

import com.deliveredtechnologies.rulebook.Fact;
import com.deliveredtechnologies.rulebook.FactMap;
import com.deliveredtechnologies.rulebook.NameValueReferableMap;
import com.deliveredtechnologies.rulebook.model.RuleBook;
import com.example.demo.controllers.responses.GetHelloResponse;
import com.example.demo.controllers.responses.ImmutableGetHelloResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class HelloController {
    @Autowired
    private RuleBook<List<String>> ruleBook;


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
    public List<Integer> simpleFlux() throws Exception {
        System.out.println("simpleFlux:thread:" + Thread.currentThread().getName());
        List<Integer> integers = List.of(1, 2);
        return Flux.fromIterable(integers)
                .parallel()
                .runOn(Schedulers.boundedElastic())
                .flatMap(n-> {
                    System.out.println("simpleFlux:doOnNext1:thread:" + Thread.currentThread().getName() + ": i = " + n);
                    return Mono.just(n * 2);
                })
                .sequential()
                .parallel()
                .runOn(Schedulers.parallel())
                .doOnNext(n -> {
                    System.out.println("simpleFlux:doOnNext2:thread:" + Thread.currentThread().getName() + ": i = " + n);
                })
                .sequential()
                .collectList()
                .block();
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

    @GetMapping("/filter-inputs-by-rules")
    public List<String> filterInputsByRules() {
        NameValueReferableMap<String> facts = new FactMap<>();
        facts.put(new Fact<String>("Abacus"));
        facts.put(new Fact<String>("Arabian"));
        facts.put(new Fact<String>("Cat"));
        facts.put(new Fact<String>("Camel"));
        facts.put(new Fact<String>("Bear"));
        facts.put(new Fact<String>("Boom"));
        facts.put(new Fact<String>("Aracade"));
        facts.put(new Fact<String>("Basic"));
        ruleBook.run(facts);

        List<String> filteredResult = ruleBook.getResult().isPresent()
                ? ruleBook.getResult().get().getValue()
                : new ArrayList<String>();
        return filteredResult;
    }

    @GetMapping("/webClient-test")
    public String webClientTest() {
        System.out.println("Before webClientThread: " + Thread.currentThread().getName());
        WebClient.builder().build().get().uri("https://jsonplaceholder.typicode.com/todos/1")
                .retrieve()
                .bodyToMono(String.class)
                .doOnNext(data->{
                    System.out.println("1 Inside webClientThread: " + Thread.currentThread().getName());
                    System.out.println(data);
                })
                .subscribe();

        WebClient.builder().build().get().uri("https://jsonplaceholder.typicode.com/todos/1")
                .retrieve()
                .bodyToMono(String.class)
                .doOnNext(data->{
                    System.out.println("2 Inside webClientThread: " + Thread.currentThread().getName());
                    System.out.println(data);
                })
                .subscribe();

        System.out.println("After webClientThread: " + Thread.currentThread().getName());
        return "Done!!";
    }

}
