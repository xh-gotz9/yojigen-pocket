package cn.gotz9.pocket.redis;

import cn.gotz9.pocket.AbstractOneParamAccessor;
import cn.gotz9.pocket.ParamConverter;
import cn.gotz9.pocket.codec.ValueCodec;
import cn.gotz9.pocket.redis.storage.JedisFixedHashStorage;
import cn.gotz9.pocket.storage.DataStorageProvider;
import redis.clients.jedis.Jedis;

public class GenericRedisFixedHashSlot<T, P> extends AbstractOneParamAccessor<T, P> {

    public GenericRedisFixedHashSlot(ValueCodec<T> codec, String key, DataStorageProvider<Jedis> storageProvider, ParamConverter<P, String> paramConverter) {
        super(codec, new JedisFixedHashStorage(key, storageProvider), paramConverter);
    }

}
