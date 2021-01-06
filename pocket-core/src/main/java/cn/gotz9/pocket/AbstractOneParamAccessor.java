package cn.gotz9.pocket;

import cn.gotz9.pocket.codec.CodecUtil;
import cn.gotz9.pocket.codec.ValueCodec;
import cn.gotz9.pocket.storage.OneParamByteStorage;
import cn.gotz9.pocket.storage.OneParamByteStorageProxy;
import cn.gotz9.pocket.storage.StorageUtil;

import java.util.Optional;

public abstract class AbstractOneParamAccessor<T, P> implements OneParamAccessor<T, P> {

    private final ValueCodec<T> codec;

    private final OneParamByteStorage<P> byteStorage;

    public AbstractOneParamAccessor(ValueCodec<T> codec, OneParamByteStorage<P> byteStorage) {
        this.codec = codec;
        this.byteStorage = byteStorage;
    }

    public <I> AbstractOneParamAccessor(ValueCodec<T> codec, OneParamByteStorage<I> byteStorage, ParamConverter<P, I> paramConverter) {
        this(codec, new OneParamByteStorageProxy<>(byteStorage, paramConverter));
    }

    @Override
    public Optional<T> fetchVal(P param) {
        byte[] bytes = StorageUtil.readBytes(byteStorage, param);

        T val;
        if (bytes != null && (val = CodecUtil.decode(codec, bytes)) != null) {
            return Optional.of(val);
        }

        return Optional.empty();
    }

    @Override
    public boolean updateVal(P param, T data) {
        return StorageUtil.writeBytes(byteStorage, param, CodecUtil.encode(codec, data));
    }

}
