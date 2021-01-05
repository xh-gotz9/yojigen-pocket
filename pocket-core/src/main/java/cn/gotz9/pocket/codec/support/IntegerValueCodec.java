package cn.gotz9.pocket.codec.support;

import cn.gotz9.pocket.codec.ValueCodec;

public class IntegerValueCodec implements ValueCodec<Integer> {

    @Override
    public byte[] encode(Integer val) throws Exception {
        return new byte[]{(byte) (val >> 24), (byte) (val >> 16), (byte) (val >> 8), val.byteValue()};
    }

    @Override
    public Integer decode(byte[] bytes) throws Exception {
        if (bytes.length < 4) {
            throw new IndexOutOfBoundsException("length < 4");
        }

        int v = 0;
        for (int i = 0; i < 4; i++) {
            v = v << 8 + bytes[i];
        }

        return v;
    }

}
