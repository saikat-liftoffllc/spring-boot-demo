package com.example.demo.controllers;

import com.example.demo.controllers.responses.GetHelloResponse;
import com.example.demo.controllers.responses.ImmutableGetHelloResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/thread-details")
    public Object getTheredDetails() {
        Long threadId = Thread.currentThread().getId();
        String threadName = Thread.currentThread().getName();
        Map<String, String> map = new HashMap<>();
        map.put("threadId", threadId.toString());
        map.put("threadName", threadName);
        return map;
    }

    @GetMapping("simple-flux")
    public List<Integer> simpleFlux() throws Exception{
        List<Integer> elements = new ArrayList<>();
        Flux.just(1, 2, 3, 4)
                .log()
                .subscribeOn(Schedulers.parallel())
                .doOnNext(n->{
                    try {
                        elements.add(n);
                        Thread.sleep(1000);
                    } catch(Exception e){}
                })
                .delayElements(Duration.ofSeconds(1))
                .blockLast();
//                .subscribe(elements::add);
        logCurrentTheredInfo();
        System.out.println("List: " + elements);
        return elements;
    }

    private void logCurrentTheredInfo() {
        Map<String, String> info = getCurrentThreadInfo();
        System.out.println(info);
    }


    private Map<String, String> getCurrentThreadInfo() {
        Long threadId = Thread.currentThread().getId();
        String threadName = Thread.currentThread().getName();
        Map<String, String> map = new HashMap<>();
        map.put("threadId", threadId.toString());
        map.put("threadName", threadName);
        return map;
    }
}
