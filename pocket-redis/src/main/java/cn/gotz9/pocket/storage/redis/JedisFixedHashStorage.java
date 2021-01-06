package cn.gotz9.pocket.storage.redis;

import cn.gotz9.pocket.storage.DataStorageProvider;
import redis.clients.jedis.Jedis;

/**
 * 从固定的 hash 结构获取参数指定 field 的数据
 */
public class JedisFixedHashStorage extends JedisKeyByteStorage {

    public final String key;

    public JedisFixedHashStorage(String key, DataStorageProvider<Jedis> dataStorageProvider) {
        super(dataStorageProvider);
        this.key = key;
    }

    @Override
    public byte[] readData(String field) throws Exception {
        return getSource().hget(key.getBytes(), field.getBytes());
    }

    @Override
    public boolean writeData(String field, byte[] data) throws Exception {
        getSource().hset(key.getBytes(), field.getBytes(), data);
        return true;
    }

}
