package cn.gotz9.pocket;

import java.util.Optional;

/**
 * @param <T> 存取的数据类型
 * @param <F> 第一个参数类型
 * @param <S> 第二个参数类型
 */
public interface TwoParamAccessor<T, F, S> {

    Optional<T> fetchVal(F first, S second);

    boolean updateVal(F first, S second, T data);

}
