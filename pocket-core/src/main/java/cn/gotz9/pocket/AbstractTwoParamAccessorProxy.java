package cn.gotz9.pocket;

import cn.gotz9.pocket.codec.CodecUtil;
import cn.gotz9.pocket.codec.ValueCodec;
import cn.gotz9.pocket.storage.StorageUtil;
import cn.gotz9.pocket.storage.TwoParamByteStorage;
import cn.gotz9.pocket.storage.TwoParamByteStorageProxy;

import java.util.Optional;

public abstract class AbstractTwoParamAccessorProxy<T, F, S, FI, SI> implements TwoParamAccessor<T, F, S> {

    private final TwoParamAccessor<T, FI, SI> accessor;

    private final ParamConverter<F, FI> firstConverter;

    private final ParamConverter<S, SI> secondConverter;

    public AbstractTwoParamAccessorProxy(TwoParamAccessor<T, FI, SI> accessor, ParamConverter<F, FI> firstConverter, ParamConverter<S, SI> secondConverter) {
        this.accessor = accessor;
        this.firstConverter = firstConverter;
        this.secondConverter = secondConverter;
    }

    @Override
    public Optional<T> fetchVal(F first, S second) {
        return accessor.fetchVal(firstConverter.convert(first), secondConverter.convert(second));
    }

    @Override
    public boolean updateVal(F first, S second, T data) {
        return accessor.updateVal(firstConverter.convert(first), secondConverter.convert(second), data);
    }
}
