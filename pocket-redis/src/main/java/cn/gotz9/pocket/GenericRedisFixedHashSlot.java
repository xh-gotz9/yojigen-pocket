package cn.gotz9.pocket;

import cn.gotz9.pocket.codec.ValueCodec;
import cn.gotz9.pocket.storage.DataStorageProvider;
import cn.gotz9.pocket.storage.OneParamByteStorage;
import cn.gotz9.pocket.storage.redis.JedisFixedHashStorage;
import cn.gotz9.pocket.storage.redis.JedisKeyByteStorage;
import redis.clients.jedis.Jedis;

public class GenericRedisFixedHashSlot<T, P> extends AbstractOneParamAccessor<T, P> {

    public GenericRedisFixedHashSlot(ValueCodec<T> codec, String key, DataStorageProvider<Jedis> storageProvider, ParamConverter<P, String> paramConverter) {
        super(codec, new JedisFixedHashStorage(key, storageProvider), paramConverter);
    }

}
