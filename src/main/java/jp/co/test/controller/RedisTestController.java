package jp.co.test.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RedisTestController {

    private final StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/redis")
    public String redis() {
        stringRedisTemplate.opsForValue().set("test", "aaaa");
        String getFromRedis = stringRedisTemplate.opsForValue().get("test");
        return getFromRedis;
    }
}
