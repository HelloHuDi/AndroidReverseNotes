package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;

public final class zzch implements DeleteDataItemsResult {
    private final int zzdh;
    private final Status zzp;

    public zzch(Status status, int i) {
        this.zzp = status;
        this.zzdh = i;
    }

    public final int getNumDeleted() {
        return this.zzdh;
    }

    public final Status getStatus() {
        return this.zzp;
    }
}
