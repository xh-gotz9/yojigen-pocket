package cn.gotz9.pocket.storage;

/**
 * @param <P> param type
 */
public interface OneParamByteStorage<P> {

    byte[] readBytes(P param1) throws Exception;

    boolean writeBytes(P param1, byte[] data) throws Exception;

}
