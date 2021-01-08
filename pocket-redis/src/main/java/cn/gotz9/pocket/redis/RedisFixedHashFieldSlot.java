package cn.gotz9.pocket.redis;

import cn.gotz9.pocket.ParamConverter;
import cn.gotz9.pocket.codec.ValueCodec;
import cn.gotz9.pocket.redis.storage.JedisKeyByteStorage;

public class RedisFixedHashFieldSlot<T> extends GenericRedisFixedHashFieldSlot<T, String> {

    public RedisFixedHashFieldSlot(ValueCodec<T> codec, String field, JedisKeyByteStorage byteStorage, ParamConverter<String, String> paramConverter) {
        super(codec, field, byteStorage, paramConverter);
    }

    public RedisFixedHashFieldSlot(ValueCodec<T> codec, String field, JedisKeyByteStorage byteStorage) {
        super(codec, field, byteStorage, String::toString);
    }

}
