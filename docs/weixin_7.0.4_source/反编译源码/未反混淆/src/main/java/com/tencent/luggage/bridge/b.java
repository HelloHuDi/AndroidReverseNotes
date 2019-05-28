package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;

enum b {
    NONE,
    READY,
    INVOKE,
    CALLBACK,
    EVENT,
    SUBSCRIBE,
    UNSUBSCRIBE;

    static {
        AppMethodBeat.o(90714);
    }
}
