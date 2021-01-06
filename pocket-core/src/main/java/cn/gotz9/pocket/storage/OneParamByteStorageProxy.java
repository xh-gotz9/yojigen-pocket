package cn.gotz9.pocket.storage;

import cn.gotz9.pocket.ParamConverter;

public class OneParamByteStorageProxy<O, I> implements OneParamByteStorage<O> {

    private final OneParamByteStorage<I> proxyTarget;

    private final ParamConverter<O, I> converter;

    public OneParamByteStorageProxy(OneParamByteStorage<I> proxyTarget, ParamConverter<O, I> converter) {
        this.proxyTarget = proxyTarget;
        this.converter = converter;
    }

    @Override
    public byte[] readData(O param1) throws Exception {
        return proxyTarget.readData(converter.convert(param1));
    }

    @Override
    public boolean writeData(O param1, byte[] data) throws Exception {
        return proxyTarget.writeData(converter.convert(param1), data);
    }

}
