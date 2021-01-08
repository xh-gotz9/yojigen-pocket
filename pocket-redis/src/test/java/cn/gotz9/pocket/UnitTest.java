package cn.gotz9.pocket;

import cn.gotz9.pocket.codec.support.KryoValueCodec;
import cn.gotz9.pocket.storage.OneParamByteStorage;
import cn.gotz9.pocket.storage.redis.JedisFixedHashFieldStorage;
import lombok.Getter;
import lombok.Setter;
import org.junit.Assert;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.io.ByteArrayOutputStream;
import java.util.Objects;
import java.util.Optional;

import static cn.gotz9.pocket.codec.support.ValueCodecEnum.STRING_VALUE_CODEC;

public class UnitTest {

    @Getter
    @Setter
    public static class TestObj {

        private String name = "";

        public TestObj() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TestObj testObj = (TestObj) o;
            return Objects.equals(name, testObj.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    @Test
    public void accessorTest() {
        JedisFixedHashFieldStorage byteStorage = new JedisFixedHashFieldStorage("hash-key",
                () -> new Jedis("127.0.0.1", 6379));

        GenericRedisKeySlot<TestObj, TestObj> accessor = new GenericRedisKeySlot<>(new KryoValueCodec<>(), byteStorage, TestObj::getName);

        TestObj testObj = new TestObj();
        testObj.name = "test-name";

        accessor.updateVal(testObj, testObj);

        Optional<TestObj> testObj1 = accessor.fetchVal(testObj);

        Assert.assertEquals(Optional.of(testObj), testObj1);
    }

    @Test
    public void redisAccessorTest() {
        RedisFixedHashSlot<String> hashSlot = new RedisFixedHashSlot<String>(STRING_VALUE_CODEC, "jedis-hash", () -> new Jedis("127.0.0.1", 6379));

        String data = "data";
        Assert.assertTrue(hashSlot.updateVal("field", data));
        Assert.assertTrue(hashSlot.fetchVal("field").map(s -> Objects.equals(s, data)).orElse(false));
    }

    private static class ByteArrayOutputStreamStringDataStorage implements OneParamByteStorage<String> {

        private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        @Override
        public byte[] readData(String param1) {
            return outputStream.toByteArray();
        }

        @Override
        public boolean writeData(String param1, byte[] data) {
            outputStream.write(data, 0, data.length);
            return true;
        }

    }
}
