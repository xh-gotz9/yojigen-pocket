package cn.gotz9.pocket.codec.support;

import cn.gotz9.pocket.codec.ValueCodec;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.ByteArrayOutputStream;

public class KryoValueCodec<T> implements ValueCodec<T> {

    /**
     * default Kryo Instance for codec
     */
    private static final Kryo KRYO = new Kryo();

    private final Kryo kryo;

    public KryoValueCodec() {
        kryo = KRYO;
    }

    public KryoValueCodec(Kryo kryo) {
        this.kryo = kryo;
    }

    @Override
    public T decode(byte[] bytes) {
        Input input = new Input(bytes);
        return (T) kryo.readClassAndObject(input);
    }

    @Override
    public byte[] encode(T val) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Output output = new Output(byteArrayOutputStream);
        kryo.writeClassAndObject(output, val);
        return output.toBytes();
    }
}
