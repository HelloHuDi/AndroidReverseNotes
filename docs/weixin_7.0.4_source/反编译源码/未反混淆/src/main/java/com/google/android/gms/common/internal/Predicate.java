package com.google.android.gms.common.internal;

public interface Predicate<T> {
    boolean apply(T t);

    boolean equals(Object obj);
}
