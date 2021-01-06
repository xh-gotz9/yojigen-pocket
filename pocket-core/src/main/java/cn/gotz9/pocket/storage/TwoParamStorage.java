package cn.gotz9.pocket.storage;

public interface TwoParamStorage<T, F, S> {

    T readData(F param1, S param2);

    boolean writeData(F param1, S param2, T data);

}
