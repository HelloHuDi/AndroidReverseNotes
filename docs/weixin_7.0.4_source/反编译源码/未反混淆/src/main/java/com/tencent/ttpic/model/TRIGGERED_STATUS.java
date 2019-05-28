package com.tencent.ttpic.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum TRIGGERED_STATUS {
    NOT_TRIGGERED,
    TRIGGERED,
    FIRST_TRIGGERED;

    static {
        AppMethodBeat.o(83531);
    }
}
