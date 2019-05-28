package com.tencent.mm.plugin.appbrand.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b {
    FOREGROUND,
    BACKGROUND,
    SUSPEND,
    DESTROYED;

    static {
        AppMethodBeat.o(90974);
    }
}
