package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Node;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;

public final class zzw implements CapabilityInfo {
    private final String name;
    private final Set<Node> zzbt;

    public zzw(CapabilityInfo capabilityInfo) {
        this(capabilityInfo.getName(), capabilityInfo.getNodes());
        AppMethodBeat.m2504i(71476);
        AppMethodBeat.m2505o(71476);
    }

    private zzw(String str, Set<Node> set) {
        this.name = str;
        this.zzbt = set;
    }

    public final String getName() {
        return this.name;
    }

    public final Set<Node> getNodes() {
        return this.zzbt;
    }
}
