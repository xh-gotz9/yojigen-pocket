package cn.gotz9.pocket;

import cn.gotz9.pocket.codec.ValueCodec;
import cn.gotz9.pocket.storage.OneParamByteStorage;

import java.util.Optional;

public abstract class AbstractOneParamAccessorProxy<T, P, PI> implements OneParamAccessor<T, P> {

    private final OneParamAccessor<T, PI> accessor;
    private final ParamConverter<P, PI> paramConverter;

    public AbstractOneParamAccessorProxy(OneParamAccessor<T, PI> accessor, ParamConverter<P, PI> paramConverter) {
        this.accessor = accessor;
        this.paramConverter = paramConverter;
    }

    @Override
    public Optional<T> fetchVal(P param) {
        return accessor.fetchVal(paramConverter.convert(param));
    }

    @Override
    public boolean updateVal(P param, T data) {
        return accessor.updateVal(paramConverter.convert(param), data);
    }

}
