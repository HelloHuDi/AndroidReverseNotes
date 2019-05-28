package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.CapabilityApi.GetAllCapabilitiesResult;
import com.google.android.gms.wearable.CapabilityInfo;
import java.util.Map;

public final class zzx implements GetAllCapabilitiesResult {
    private final Map<String, CapabilityInfo> zzbu;
    private final Status zzp;

    public zzx(Status status, Map<String, CapabilityInfo> map) {
        this.zzp = status;
        this.zzbu = map;
    }

    public final Map<String, CapabilityInfo> getAllCapabilities() {
        return this.zzbu;
    }

    public final Status getStatus() {
        return this.zzp;
    }
}
