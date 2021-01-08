package cn.gotz9.pocket;

import cn.gotz9.pocket.codec.ValueCodec;
import cn.gotz9.pocket.storage.DataStorageProvider;
import cn.gotz9.pocket.storage.OneParamByteStorage;
import cn.gotz9.pocket.storage.redis.JedisFixedHashStorage;
import cn.gotz9.pocket.storage.redis.JedisKeyByteStorage;
import redis.clients.jedis.Jedis;

public class RedisFixedHashSlot<T> extends GenericRedisFixedHashSlot<T, String> {

    public RedisFixedHashSlot(ValueCodec<T> codec, String key, DataStorageProvider<Jedis> storageProvider, ParamConverter<String, String> paramConverter) {
        super(codec, key, storageProvider, paramConverter);
    }

    public RedisFixedHashSlot(ValueCodec<T> codec, String key, DataStorageProvider<Jedis> storageProvider) {
        super(codec, key, storageProvider, String::toString);
    }

}
