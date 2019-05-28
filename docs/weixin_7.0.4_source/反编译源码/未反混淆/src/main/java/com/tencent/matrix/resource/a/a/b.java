package com.tencent.matrix.resource.a.a;

public final class b {
    public static <T> T d(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str + " must not be null");
    }
}
