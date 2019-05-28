package com.tencent.luggage.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b {
    PENDING,
    PASS,
    REJECT;

    static {
        AppMethodBeat.o(90863);
    }
}
