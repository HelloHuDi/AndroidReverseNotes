package com.facebook.appevents.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum SubscriptionType {
    NEW,
    HEARTBEAT,
    EXPIRE,
    CANCEL,
    RESTORE,
    DUPLICATED,
    UNKNOWN;

    static {
        AppMethodBeat.o(72231);
    }
}
