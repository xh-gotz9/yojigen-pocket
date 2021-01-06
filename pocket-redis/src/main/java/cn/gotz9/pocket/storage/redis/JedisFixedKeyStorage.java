package cn.gotz9.pocket.storage.redis;

import cn.gotz9.pocket.codec.CodecException;
import cn.gotz9.pocket.storage.AbstractStorage;
import cn.gotz9.pocket.storage.DataStorageProvider;
import cn.gotz9.pocket.storage.NoParamByteStorage;
import redis.clients.jedis.Jedis;

/**
 * 在固定的 redis key 上读写数据
 */
public class JedisFixedKeyStorage extends AbstractStorage<Jedis> implements NoParamByteStorage<Jedis> {

    private final String key;

    public JedisFixedKeyStorage(DataStorageProvider<Jedis> dataStorageProvider, String key) {
        super(dataStorageProvider);
        this.key = key;
    }

    @Override
    public byte[] readBytes() {
        return getSource().get(key.getBytes());
    }

    @Override
    public boolean writeBytes(byte[] data) {
        try {
            getSource().set(key.getBytes(), data);
            return true;
        } catch (Exception e) {
            throw new CodecException("fetch bytes failed", e);
        }
    }

}
