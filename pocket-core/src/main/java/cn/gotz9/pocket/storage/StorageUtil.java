package cn.gotz9.pocket.storage;

public class StorageUtil {

    public static <P> byte[] readBytes(OneParamByteStorage<P> storage, P param) {
        try {
            return storage.readData(param);
        } catch (Exception e) {
            throw new StorageException("write bytes failed", e);
        }
    }

    public static <P> boolean writeBytes(OneParamByteStorage<P> storage, P param, byte[] data) {
        try {
            return storage.writeData(param, data);
        } catch (Exception e) {
            throw new StorageException("write bytes failed", e);
        }
    }

    public static <F, S> byte[] readBytes(TwoParamByteStorage<F, S> storage, F param1, S param2) {
        try {
            return storage.readData(param1, param2);
        } catch (Exception e) {
            throw new StorageException("write bytes failed", e);
        }
    }

    public static <F, S> boolean writeBytes(TwoParamByteStorage<F, S> storage, F param1, S param2, byte[] data) {
        try {
            return storage.writeData(param1, param2, data);
        } catch (Exception e) {
            throw new StorageException("write bytes failed", e);
        }
    }
}
