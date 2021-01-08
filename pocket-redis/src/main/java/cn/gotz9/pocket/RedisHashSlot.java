package cn.gotz9.pocket;

import cn.gotz9.pocket.codec.ValueCodec;
import cn.gotz9.pocket.storage.DataStorageProvider;
import cn.gotz9.pocket.storage.redis.JedisHashStorage;
import redis.clients.jedis.Jedis;

public class RedisHashSlot<T> extends GenericRedisHashSlot<T, String, String> {

    public RedisHashSlot(ValueCodec<T> codec, DataStorageProvider<Jedis> storageProvider, ParamConverter<String, String> keyConverter, ParamConverter<String, String> fieldConverter) {
        super(codec, storageProvider, keyConverter, fieldConverter);
    }

    public RedisHashSlot(ValueCodec<T> codec, DataStorageProvider<Jedis> storageProvider) {
        super(codec, new JedisHashStorage(storageProvider), String::toString, String::toString);
    }

}
