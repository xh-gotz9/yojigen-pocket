package cn.gotz9.pocket;

import cn.gotz9.pocket.codec.CodecUtil;
import cn.gotz9.pocket.codec.ValueCodec;
import cn.gotz9.pocket.storage.OneParamByteStorage;
import cn.gotz9.pocket.storage.StorageUtil;

import java.util.Optional;

public abstract class AbstractOneParamAccessor<T, P> implements OneParamAccessor<T, P> {

    private final ValueCodec<T> codec;

    private final OneParamByteStorage<String> byteStorage;

    private final ParamConverter<P, String> keyGenerator;

    public AbstractOneParamAccessor(ValueCodec<T> codec, OneParamByteStorage<String> byteStorage, ParamConverter<P, String> keyGenerator) {
        this.codec = codec;
        this.byteStorage = byteStorage;
        this.keyGenerator = keyGenerator;
    }

    @Override
    public Optional<T> fetchVal(P param) {
        byte[] bytes = StorageUtil.readBytes(byteStorage, keyGenerator.convert(param));

        T val;
        if (bytes != null && (val = CodecUtil.decode(codec, bytes)) != null) {
            return Optional.of(val);
        }

        return Optional.empty();
    }

    @Override
    public boolean updateVal(P param, T data) {
        return StorageUtil.writeBytes(byteStorage, keyGenerator.convert(param), CodecUtil.encode(codec, data));
    }

}
