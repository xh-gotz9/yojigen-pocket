package cn.gotz9.pocket.storage;

import cn.gotz9.pocket.ParamConverter;

public class TwoParamByteStorageProxy<F, S, FI, SI> implements TwoParamByteStorage<F, S> {

    private final TwoParamByteStorage<FI, SI> proxyTarget;

    private final ParamConverter<F, FI> firstParamConverter;
    private final ParamConverter<S, SI> secondParamConverter;

    public TwoParamByteStorageProxy(TwoParamByteStorage<FI, SI> proxyTarget, ParamConverter<F, FI> firstParamConverter, ParamConverter<S, SI> secondParamConverter) {
        this.proxyTarget = proxyTarget;
        this.firstParamConverter = firstParamConverter;
        this.secondParamConverter = secondParamConverter;
    }


    @Override
    public byte[] readData(F param1, S param2) {
        return proxyTarget.readData(firstParamConverter.convert(param1), secondParamConverter.convert(param2));
    }

    @Override
    public boolean writeData(F param1, S param2, byte[] data) {
        return proxyTarget.writeData(firstParamConverter.convert(param1), secondParamConverter.convert(param2), data);
    }
}
