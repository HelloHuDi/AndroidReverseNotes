package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import java.util.List;

public final class zzfj implements GetConnectedNodesResult {
    private final List<Node> zzdx;
    private final Status zzp;

    public zzfj(Status status, List<Node> list) {
        this.zzp = status;
        this.zzdx = list;
    }

    public final List<Node> getNodes() {
        return this.zzdx;
    }

    public final Status getStatus() {
        return this.zzp;
    }
}
