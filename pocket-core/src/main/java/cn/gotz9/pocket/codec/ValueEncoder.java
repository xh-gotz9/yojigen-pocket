package cn.gotz9.pocket.codec;

public interface ValueEncoder<T> {

    byte[] encode(T val) throws Exception;

}
