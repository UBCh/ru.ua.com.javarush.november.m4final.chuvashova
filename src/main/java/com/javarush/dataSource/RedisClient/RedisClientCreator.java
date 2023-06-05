package com.javarush.dataSource.RedisClient;


import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import lombok.NoArgsConstructor;

import static io.lettuce.core.RedisClient.create;

@NoArgsConstructor
public class RedisClientCreator {


    public RedisClient prepareRedisClient() {

	RedisClient redisClient = create(RedisURI.create("localhost", 6379));
	try (StatefulRedisConnection<String, String> connection = redisClient.connect()) {
	}
	return redisClient;
    }
}
