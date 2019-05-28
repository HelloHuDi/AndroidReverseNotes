package com.google.android.gms.common.util;

public interface Function<F, T> {
    T apply(F f);

    boolean equals(Object obj);
}
