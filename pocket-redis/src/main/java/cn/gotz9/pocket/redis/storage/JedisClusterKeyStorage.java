package cn.gotz9.pocket.redis.storage;

import cn.gotz9.pocket.storage.AbstractStorage;
import cn.gotz9.pocket.storage.DataStorageProvider;
import cn.gotz9.pocket.storage.OneParamByteStorage;
import redis.clients.jedis.JedisCluster;

public class JedisClusterKeyStorage extends AbstractStorage<JedisCluster> implements OneParamByteStorage<String> {

    public JedisClusterKeyStorage(DataStorageProvider<JedisCluster> dataStorageProvider) {
        super(dataStorageProvider);
    }

    @Override
    public byte[] readData(String param1) {
        return getSource().get(param1.getBytes());
    }

    @Override
    public boolean writeData(String param1, byte[] data) {
        getSource().set(param1.getBytes(), data);
        return true;
    }

}
