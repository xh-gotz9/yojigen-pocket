package cn.gotz9.pocket.storage.redis;

import cn.gotz9.pocket.codec.CodecException;
import cn.gotz9.pocket.storage.AbstractStorage;
import cn.gotz9.pocket.storage.DataStorageProvider;
import cn.gotz9.pocket.storage.TwoParamByteStorage;
import redis.clients.jedis.Jedis;

public class JedisHashStorage extends AbstractStorage<Jedis> implements TwoParamByteStorage<String, String> {

    public JedisHashStorage(DataStorageProvider<Jedis> storageProvider) {
        super(storageProvider);
    }

    @Override
    public byte[] readData(String key, String field) {
        return getSource().hget(key.getBytes(), field.getBytes());
    }

    @Override
    public boolean writeData(String key, String field, byte[] data) {
        try {
            getSource().hset(key.getBytes(), field.getBytes(), data);
            return true;
        } catch (Exception e) {
            throw new CodecException("fetch bytes failed", e);
        }
    }

}
