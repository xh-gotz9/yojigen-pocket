package cn.gotz9.pocket.storage;

/**
 * @param <D> datasource type
 */
public interface NoParamByteStorage<D> {

    byte[] readBytes() throws Exception;

    boolean writeBytes(byte[] data) throws Exception;

}
