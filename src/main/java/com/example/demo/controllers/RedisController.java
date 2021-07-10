package com.example.demo.controllers;

import io.lettuce.core.RedisClient;
import io.lettuce.core.pubsub.StatefulRedisPubSubConnection;
import io.lettuce.core.pubsub.api.reactive.ChannelMessage;
import io.lettuce.core.pubsub.api.reactive.RedisPubSubReactiveCommands;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/redis-subscription/{channel}")
    public String redisSubscription(@PathVariable String channel) {
        redisReactiveForSubscribe.subscribe(channel).subscribe();
        String message;
        try {
            var channelMessage = redisReactiveForSubscribe
                    .observeChannels()
                    .filter(c -> c.getChannel().equals(channel))
                    .blockFirst(Duration.ofSeconds(60));
            System.out.println("channel: " + channelMessage.getChannel() + "; Message: " + channelMessage.getMessage());
            message = channelMessage.getMessage();
        } catch (Exception e) {
            message = "Timeout on blocking read";
        } finally {
            redisReactiveForSubscribe.unsubscribe(channel).subscribe();
        }

        return message;
    }

    @GetMapping("/redis-publish/{channel}/{message}")
    public String redisPublish(@PathVariable String channel, @PathVariable String message) {
        redisReactiveForPublish.publish(channel, message).subscribe();
        return "Published to " + channel + "; Message: " + message;
    }
}
