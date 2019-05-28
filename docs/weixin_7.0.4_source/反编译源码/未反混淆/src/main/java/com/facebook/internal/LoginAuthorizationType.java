package com.facebook.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum LoginAuthorizationType {
    READ,
    PUBLISH;

    static {
        AppMethodBeat.o(96653);
    }
}
