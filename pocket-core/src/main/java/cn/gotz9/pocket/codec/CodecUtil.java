package cn.gotz9.pocket.codec;

public class CodecUtil {

    public static <T> T decode(ValueDecoder<T> decoder, byte[] data) {
        try {
            return decoder.decode(data);
        } catch (Exception e) {
            throw new CodecException("decode failed", e);
        }
    }

    public static <T> byte[] encode(ValueEncoder<T> encoder, T val) {
        try {
            return encoder.encode(val);
        } catch (Exception e) {
            throw new CodecException("encode failed", e);
        }
    }

}
