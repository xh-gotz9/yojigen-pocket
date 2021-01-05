package cn.gotz9.pocket;

import cn.gotz9.pocket.codec.ValueCodec;
import cn.gotz9.pocket.storage.redis.JedisKeyStorage;

/**
 * @param <T> 存取的数据类型
 * @param <K> 参数的类型
 */
public class RedisKeyField<T, K> extends AbstractOneParamAccessor<T, K> {

    public RedisKeyField(ValueCodec<T> codec, JedisKeyStorage byteStorage, ParamConverter<K, String> stringGenerator) {
        super(codec, byteStorage, stringGenerator);
    }

}
