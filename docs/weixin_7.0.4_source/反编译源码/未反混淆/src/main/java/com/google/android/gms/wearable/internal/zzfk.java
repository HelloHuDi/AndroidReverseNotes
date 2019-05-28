package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;

public final class zzfk implements GetLocalNodeResult {
    private final Node zzel;
    private final Status zzp;

    public zzfk(Status status, Node node) {
        this.zzp = status;
        this.zzel = node;
    }

    public final Node getNode() {
        return this.zzel;
    }

    public final Status getStatus() {
        return this.zzp;
    }
}
