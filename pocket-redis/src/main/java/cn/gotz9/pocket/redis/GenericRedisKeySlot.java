package cn.gotz9.pocket.redis;

import cn.gotz9.pocket.AbstractOneParamAccessor;
import cn.gotz9.pocket.ParamConverter;
import cn.gotz9.pocket.codec.ValueCodec;
import cn.gotz9.pocket.redis.storage.JedisKeyByteStorage;
import cn.gotz9.pocket.storage.DataStorageProvider;
import redis.clients.jedis.Jedis;

/**
 * @param <T> 存取的数据类型
 * @param <K> 参数的类型
 */
public class GenericRedisKeySlot<T, K> extends AbstractOneParamAccessor<T, K> {

    public GenericRedisKeySlot(ValueCodec<T> codec, DataStorageProvider<Jedis> storageProvider, ParamConverter<K, String> paramConverter) {
        super(codec, new JedisKeyByteStorage(storageProvider), paramConverter);
    }

}