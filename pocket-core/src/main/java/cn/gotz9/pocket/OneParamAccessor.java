package cn.gotz9.pocket;

import java.util.Optional;

public interface OneParamAccessor<T, P> {

    Optional<T> fetchVal(P param);

    boolean updateVal(P param, T data);

}
