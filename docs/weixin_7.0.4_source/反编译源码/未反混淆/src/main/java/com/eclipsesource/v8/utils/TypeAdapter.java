package com.eclipsesource.v8.utils;

public interface TypeAdapter {
    public static final Object DEFAULT = new Object();

    Object adapt(int i, Object obj);
}
