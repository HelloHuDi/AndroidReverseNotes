package com.google.android.gms.wearable;

import java.util.Set;

public interface CapabilityInfo {
    String getName();

    Set<Node> getNodes();
}
