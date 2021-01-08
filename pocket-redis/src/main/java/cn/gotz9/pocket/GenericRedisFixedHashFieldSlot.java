package cn.gotz9.pocket;

import cn.gotz9.pocket.codec.ValueCodec;
import cn.gotz9.pocket.storage.DataStorageProvider;
import cn.gotz9.pocket.storage.redis.JedisFixedHashFieldStorage;
import cn.gotz9.pocket.storage.redis.JedisKeyByteStorage;
import redis.clients.jedis.Jedis;

public class GenericRedisFixedHashFieldSlot<T, K> extends AbstractOneParamAccessor<T, K> {

    public GenericRedisFixedHashFieldSlot(ValueCodec<T> codec, String field, DataStorageProvider<Jedis> storageProvider, ParamConverter<K, String> paramConverter) {
        super(codec, new JedisFixedHashFieldStorage(field, storageProvider), paramConverter);
    }

}
