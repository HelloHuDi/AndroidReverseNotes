package com.tencent.mm.plugin.multitalk.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum e {
    Init,
    Inviting,
    Creating,
    Starting,
    Talking;

    static {
        AppMethodBeat.o(54199);
    }
}
