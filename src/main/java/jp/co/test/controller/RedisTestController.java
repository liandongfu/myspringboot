package jp.co.test.controller;

import jp.co.test.conifg.ObjectRedisTemplate;
import jp.co.test.domin.RedisData;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("redis")
public class RedisTestController {

    private final StringRedisTemplate stringRedisTemplate;
    private final ObjectRedisTemplate redisTemplate;

    @GetMapping("/string")
    public String stringTemp() {
        stringRedisTemplate.opsForValue().set("test", "aaaa");
        stringRedisTemplate.boundValueOps("test").append("bbbb");
        return stringRedisTemplate.opsForValue().get("test");
    }

    @GetMapping("/default")
    public String defaultTemp() {
        RedisData redisData = new RedisData();
        redisData.setId(11);
        redisData.setName("name");
        redisTemplate.opsForValue().set("testData", redisData);
        RedisData getRedisData = (RedisData) redisTemplate.opsForValue().get("testData");
        return getRedisData.toString();
    }
}
