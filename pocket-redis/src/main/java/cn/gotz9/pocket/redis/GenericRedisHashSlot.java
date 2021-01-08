package cn.gotz9.pocket.redis;

import cn.gotz9.pocket.AbstractTwoParamAccessor;
import cn.gotz9.pocket.ParamConverter;
import cn.gotz9.pocket.codec.ValueCodec;
import cn.gotz9.pocket.redis.storage.JedisHashStorage;
import cn.gotz9.pocket.storage.DataStorageProvider;
import redis.clients.jedis.Jedis;

public class GenericRedisHashSlot<T, K, F> extends AbstractTwoParamAccessor<T, K, F> {

    public GenericRedisHashSlot(ValueCodec<T> codec, DataStorageProvider<Jedis> storageProvider, ParamConverter<K, String> keyConverter, ParamConverter<F, String> fieldConverter) {
        super(codec, new JedisHashStorage(storageProvider), keyConverter, fieldConverter);
    }

}
