package cn.gotz9.pocket.redis.storage;

import cn.gotz9.pocket.storage.DataStorageProvider;
import redis.clients.jedis.Jedis;

/**
 * 从参数指定的 hash 结构的固定 field 获取数据
 */
public class JedisFixedHashFieldStorage extends JedisKeyByteStorage {

    public final String field;

    public JedisFixedHashFieldStorage(String field, DataStorageProvider<Jedis> dataStorageProvider) {
        super(dataStorageProvider);
        this.field = field;
    }

    @Override
    public byte[] readData(String key) throws Exception {
        return getSource().hget(key.getBytes(), field.getBytes());
    }

    @Override
    public boolean writeData(String key, byte[] data) throws Exception {
        getSource().hset(key.getBytes(), field.getBytes(), data);
        return true;
    }

}
