package cn.gotz9.pocket.codec;

public interface ValueDecoder<T> {

    T decode(byte[] bytes) throws Exception;

}
