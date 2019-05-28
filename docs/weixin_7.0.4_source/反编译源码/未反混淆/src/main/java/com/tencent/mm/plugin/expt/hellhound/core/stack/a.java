package com.tencent.mm.plugin.expt.hellhound.core.stack;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a {
    CREATE(0),
    RESUME(1),
    PAUSE(2),
    STOP(3),
    DESTROY(4);
    
    int value;

    static {
        AppMethodBeat.o(73357);
    }

    private a(int i) {
        this.value = i;
    }
}
