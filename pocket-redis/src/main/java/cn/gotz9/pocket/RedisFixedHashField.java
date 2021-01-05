package cn.gotz9.pocket;

import cn.gotz9.pocket.codec.ValueCodec;
import cn.gotz9.pocket.storage.DataStorageProvider;
import cn.gotz9.pocket.storage.redis.JedisFixedHashFieldStorage;
import redis.clients.jedis.Jedis;

import java.util.Optional;

public class RedisFixedHashField<T, P> extends AbstractOneParamAccessor<T, P> {

    public RedisFixedHashField(ValueCodec<T> codec, String key, DataStorageProvider<Jedis> storageProvider, ParamConverter<P, String> keyGenerator) {
        super(codec, new JedisFixedHashFieldStorage(key, storageProvider), keyGenerator);
    }

    @Override
    public Optional<T> fetchVal(P param) {
        return Optional.empty();
    }

    @Override
    public boolean updateVal(P param, T data) {
        return false;
    }
}
