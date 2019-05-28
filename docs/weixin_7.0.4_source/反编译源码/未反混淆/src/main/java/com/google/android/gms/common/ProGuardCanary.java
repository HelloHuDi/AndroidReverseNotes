package com.google.android.gms.common;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
final class ProGuardCanary {
    @KeepForSdk
    static final String CANARY = "gms_proguard_canary";

    private ProGuardCanary() {
    }
}
