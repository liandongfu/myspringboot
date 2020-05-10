package jp.co.test.conifg;

import jp.co.test.domin.RedisData;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
@RequiredArgsConstructor
public class RedisConfig {

    private final RedisConnectionFactory redisConnectionFactory;

    @Bean
    StringRedisTemplate stringRedisTemplate() {

        return new StringRedisTemplate(redisConnectionFactory);
    }

    @Bean
    ObjectRedisTemplate<RedisData> testDataRedisTemplate() {
        ObjectRedisTemplate<RedisData> redisTemplate = new ObjectRedisTemplate(redisConnectionFactory, RedisData.class);
        return redisTemplate;
    }
}
