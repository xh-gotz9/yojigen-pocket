package cn.gotz9.pocket.codec.support;

import cn.gotz9.pocket.codec.CodecUtil;

import static cn.gotz9.pocket.codec.support.ValueCodecEnum.INTEGER_VALUE_CODEC;
import static cn.gotz9.pocket.codec.support.ValueCodecEnum.LONG_VALUE_CODEC;

public class ReflectionCodecUtil {

    private static void writeLong(long val) {
        byte[] encode = CodecUtil.encode(LONG_VALUE_CODEC, val);
    }

    private static void writeInt(int val) {
        byte[] encode = CodecUtil.encode(INTEGER_VALUE_CODEC, val);
    }

}
