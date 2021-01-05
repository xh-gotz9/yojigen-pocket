package cn.gotz9.pocket.storage.redis;

import cn.gotz9.pocket.codec.CodecException;
import cn.gotz9.pocket.storage.DataStorageProvider;
import redis.clients.jedis.Jedis;

public class JedisFixedHashFieldStorage extends JedisKeyStorage {

    public final String key;

    public JedisFixedHashFieldStorage(String key, DataStorageProvider<Jedis> dataStorageProvider) {
        super(dataStorageProvider);
        this.key = key;
    }

    @Override
    public byte[] readBytes(String param1) throws Exception {
        return getSource().hget(key.getBytes(), param1.getBytes());
    }

    @Override
    public boolean writeBytes(String param1, byte[] data) throws Exception {
        getSource().hset(key.getBytes(), param1.getBytes(), data);
        return true;
    }

}
