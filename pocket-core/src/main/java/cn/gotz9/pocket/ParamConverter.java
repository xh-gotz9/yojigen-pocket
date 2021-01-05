package cn.gotz9.pocket;

public interface ParamConverter<F, T> {

    T convert(F data);

}
