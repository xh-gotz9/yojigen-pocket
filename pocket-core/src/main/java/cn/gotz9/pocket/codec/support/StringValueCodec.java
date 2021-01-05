package cn.gotz9.pocket.codec.support;

import cn.gotz9.pocket.codec.ValueCodec;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class StringValueCodec implements ValueCodec<String> {

    private final Charset charset;

    public StringValueCodec(Charset charset) {
        this.charset = charset;
    }

    public StringValueCodec() {
        this(StandardCharsets.UTF_8);
    }

    @Override
    public byte[] encode(String val) throws Exception {
        return val.getBytes(charset);
    }

    @Override
    public String decode(byte[] bytes) throws Exception {
        return new String(bytes, charset);
    }

}
