package cn.gotz9.pocket.codec.support;

import cn.gotz9.pocket.codec.ValueCodec;

public class LongValueCodec implements ValueCodec<Long> {

    @Override
    public byte[] encode(Long val) throws Exception {
        return new byte[]{
                (byte) (val >> 56),
                (byte) (val >> 48),
                (byte) (val >> 40),
                (byte) (val >> 32),
                (byte) (val >> 24),
                (byte) (val >> 16),
                (byte) (val >> 8),
                val.byteValue()};
    }

    @Override
    public Long decode(byte[] bytes) throws Exception {
        if (bytes.length < Long.BYTES) {
            throw new IndexOutOfBoundsException("length < 8");
        }

        long v = 0;
        for (int i = 0; i < Long.BYTES; i++) {
            v = v << 8 + bytes[i];
        }
        return v;
    }

}
