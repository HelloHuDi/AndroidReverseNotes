package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public interface BiConsumer<T, U> {
    @KeepForSdk
    void accept(T t, U u);
}
