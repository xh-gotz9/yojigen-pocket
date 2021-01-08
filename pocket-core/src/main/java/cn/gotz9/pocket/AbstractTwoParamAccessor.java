package cn.gotz9.pocket;

import cn.gotz9.pocket.codec.CodecUtil;
import cn.gotz9.pocket.codec.ValueCodec;
import cn.gotz9.pocket.storage.StorageUtil;
import cn.gotz9.pocket.storage.TwoParamByteStorage;
import cn.gotz9.pocket.storage.TwoParamByteStorageProxy;

import java.util.Optional;

public abstract class AbstractTwoParamAccessor<T, F, S> implements TwoParamAccessor<T, F, S> {

    private final ValueCodec<T> codec;

    private final TwoParamByteStorage<F, S> byteStorage;

    public AbstractTwoParamAccessor(ValueCodec<T> codec, TwoParamByteStorage<F, S> byteStorage) {
        this.codec = codec;
        this.byteStorage = byteStorage;
    }

    public <I, J> AbstractTwoParamAccessor(ValueCodec<T> codec, TwoParamByteStorage<I, J> byteStorage, ParamConverter<F, I> converter1, ParamConverter<S, J> converter2) {
        this(codec, new TwoParamByteStorageProxy<>(byteStorage, converter1, converter2));
    }

    @Override
    public Optional<T> fetchVal(F param1, S param2) {
        byte[] bytes = StorageUtil.readBytes(byteStorage, param1, param2);

        T val;
        if (bytes != null && (val = CodecUtil.decode(codec, bytes)) != null) {
            return Optional.of(val);
        }

        return Optional.empty();
    }

    @Override
    public boolean updateVal(F param1, S param2, T data) {
        return StorageUtil.writeBytes(byteStorage, param1, param2, CodecUtil.encode(codec, data));
    }

}
