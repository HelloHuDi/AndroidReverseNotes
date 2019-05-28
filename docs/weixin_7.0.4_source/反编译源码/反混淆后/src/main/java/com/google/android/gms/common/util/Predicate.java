package com.google.android.gms.common.util;

public interface Predicate<T> {
    boolean apply(T t);

    boolean equals(Object obj);
}
