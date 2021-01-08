package cn.gotz9.pocket.redis;

import cn.gotz9.pocket.ParamConverter;
import cn.gotz9.pocket.codec.ValueCodec;
import cn.gotz9.pocket.redis.storage.JedisKeyByteStorage;
import cn.gotz9.pocket.storage.DataStorageProvider;
import redis.clients.jedis.Jedis;

/**
 * @param <T> 存取的数据类型
 */
public class RedisKeySlot<T> extends GenericRedisKeySlot<T, String> {

    public RedisKeySlot(ValueCodec<T> codec, DataStorageProvider<Jedis> storageProvider, ParamConverter<String, String> paramConverter) {
        super(codec, storageProvider, paramConverter);
    }

    public RedisKeySlot(ValueCodec<T> codec, JedisKeyByteStorage byteStorage) {
        super(codec, byteStorage, String::toString);
    }

}
