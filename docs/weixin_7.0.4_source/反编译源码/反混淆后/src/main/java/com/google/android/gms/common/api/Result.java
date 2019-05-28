package com.google.android.gms.common.api;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public interface Result {
    @KeepForSdk
    Status getStatus();
}
