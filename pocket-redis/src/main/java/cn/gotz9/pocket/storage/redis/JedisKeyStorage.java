package cn.gotz9.pocket.storage.redis;

import cn.gotz9.pocket.codec.CodecException;
import cn.gotz9.pocket.storage.DataStorageProvider;
import cn.gotz9.pocket.storage.OneParamByteStorage;
import redis.clients.jedis.Jedis;

public class JedisKeyStorage implements OneParamByteStorage<String>, DataStorageProvider<Jedis> {

    private final DataStorageProvider<Jedis> dataStorageProvider;

    public JedisKeyStorage(DataStorageProvider<Jedis> dataStorageProvider) {
        this.dataStorageProvider = dataStorageProvider;
    }

    @Override
    public byte[] readData(String param1) throws Exception {
        return dataStorageProvider.getSource().get(param1.getBytes());
    }

    @Override
    public boolean writeData(String param1, byte[] data) throws Exception {
        dataStorageProvider.getSource().set(param1.getBytes(), data);
        return true;
    }

    @Override
    public Jedis getSource() {
        return dataStorageProvider.getSource();
    }
}
