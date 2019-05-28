package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.CapabilityApi.AddLocalCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.RemoveLocalCapabilityResult;

public final class zzu implements AddLocalCapabilityResult, RemoveLocalCapabilityResult {
    private final Status zzp;

    public zzu(Status status) {
        this.zzp = status;
    }

    public final Status getStatus() {
        return this.zzp;
    }
}
