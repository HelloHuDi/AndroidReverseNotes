package com.tencent.mm.plugin.appbrand.widget.input.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c {
    NORMAL(0),
    BOLD(1);
    
    public final int style;

    static {
        AppMethodBeat.o(77452);
    }

    private c(int i) {
        this.style = i;
    }

    public static c EJ(String str) {
        AppMethodBeat.i(77451);
        Enum f = d.f(str, c.class);
        c cVar = NORMAL;
        if (f != null) {
            Enum cVar2 = f;
        }
        cVar2 = cVar2;
        AppMethodBeat.o(77451);
        return cVar2;
    }
}
