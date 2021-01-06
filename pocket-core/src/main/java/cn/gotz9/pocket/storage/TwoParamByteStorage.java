package cn.gotz9.pocket.storage;

public interface TwoParamByteStorage<F, S> {

    byte[] readData(F param1, S param2);

    boolean writeData(F param1, S param2, byte[] data);

}
