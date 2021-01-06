package cn.gotz9.pocket.storage;

/**
 * @param <T> storage data type
 * @param <P> param type
 */
public interface OneParamStorage<T, P> {

    T readData(P param1) throws Exception;

    boolean writeData(P param1, T data) throws Exception;

}
