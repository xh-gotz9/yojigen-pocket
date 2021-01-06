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
    public byte[] readData(String param1, String param2) {
        return getSource().get(param1.getBytes());
    }

    @Override
    public boolean writeData(String param1, String param2, byte[] data) {
        try {
            getSource().set(param1.getBytes(), data);
            return true;
        } catch (Exception e) {
            throw new CodecException("fetch bytes failed", e);
        }
    }

}
