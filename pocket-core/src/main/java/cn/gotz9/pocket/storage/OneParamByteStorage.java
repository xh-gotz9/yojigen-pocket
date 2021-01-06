package cn.gotz9.pocket.storage;

/**
 * @param <P> param type
 */
public interface OneParamByteStorage<P> {

    byte[] readData(P param1) throws Exception;

    boolean writeData(P param1, byte[] data) throws Exception;

}
