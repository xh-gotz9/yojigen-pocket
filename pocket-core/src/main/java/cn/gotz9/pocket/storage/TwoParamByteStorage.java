package cn.gotz9.pocket.storage;

public interface TwoParamByteStorage<F, S> {

    byte[] readBytes(F param1, S param2);

    boolean writeBytes(F param1, S param2, byte[] data);

}
