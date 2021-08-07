package com.example.demo.controllers;

import io.lettuce.core.RedisClient;
import io.lettuce.core.pubsub.StatefulRedisPubSubConnection;
import io.lettuce.core.pubsub.api.reactive.ChannelMessage;
import io.lettuce.core.pubsub.api.reactive.RedisPubSubReactiveCommands;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import reactor.core.scheduler.Schedulers;

@RestController
public class RedisController {
    RedisClient redisClient;
    StatefulRedisPubSubConnection<String, String> redisConnectionForPublish, redisConnectionForSubscribe;
    RedisPubSubReactiveCommands<String, String> redisReactiveForPublish;
    RedisPubSubReactiveCommands<String, String> redisReactiveForSubscribe;

    public RedisController() {
        redisClient = RedisClient.create("redis://password@localhost:6379/0");

        redisConnectionForPublish = redisClient.connectPubSub();
        redisReactiveForPublish = redisConnectionForPublish.reactive();


        redisConnectionForSubscribe = redisClient.connectPubSub();
        redisReactiveForSubscribe = redisConnectionForSubscribe.reactive();
    }

    @GetMapping("/redis-subscription")
    public List<String> redisSubscription() {
       var channels = new ArrayList<String>();
       channels.add("response_1");
        channels.add("response_2");
        channels.add("response_3");


        redisReactiveForSubscribe.subscribe(channels.get(0)).subscribe();
        redisReactiveForSubscribe.subscribe(channels.get(1)).subscribe();
        redisReactiveForSubscribe.subscribe(channels.get(2)).subscribe();

        var responses = new ArrayList<String >();
        final Counter counter = new Counter();

        try {

          redisReactiveForSubscribe
                    .observeChannels()
                    .filter(cm -> channels.contains(cm.getChannel()))
                    .doOnNext(cm-> {
                      responses.add(cm.getMessage());
                      counter.next();
                      System.out.println("Theread: " + Thread.currentThread().getName() + "; data: " + cm.getMessage() + "; Counter:" + counter);
                    })
                    .takeUntil(cm->counter.getCount() >= channels.size())
                    .collectList()
                    .block(Duration.ofSeconds(5));
        } catch (Exception e) {
          System.out.println(e);
        } finally {
          redisReactiveForSubscribe.unsubscribe(channels.get(0)).subscribe();
          redisReactiveForSubscribe.unsubscribe(channels.get(1)).subscribe();
          redisReactiveForSubscribe.unsubscribe(channels.get(2)).subscribe();
        }

        System.out.println("Counter: " + counter + "; channel size: " + channels.size());
        return responses;
    }

    @GetMapping("/redis-publish/{channel}/{message}")
    public String redisPublish(@PathVariable String channel, @PathVariable String message) {
        redisReactiveForPublish.publish(channel, message).subscribe();
        return "Published to " + channel + "; Message: " + message;
    }

    private static class Counter {
      private Integer count = 0;

      public Integer getCount() {
        return count;
      }

      public void next() {
        count++;
      }

      @Override
      public String toString() {
        return "Counter{" +
            "count=" + count +
            '}';
      }
    }


}
