package com.tencent.tmassistantsdk.util;

public class ParamPair<T, V> {
    public final T mFirstParam;
    public final V mSecondParam;

    public ParamPair(T t, V v) {
        this.mFirstParam = t;
        this.mSecondParam = v;
    }
}
