package com.tencent.mm.plugin.appbrand.widget.input.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b {
    DONE(6),
    SEARCH(3),
    NEXT(5),
    GO(2),
    SEND(4);
    
    public final int jjd;

    static {
        AppMethodBeat.o(77448);
    }

    private b(int i) {
        this.jjd = i;
    }

    public static b aRI() {
        return DONE;
    }

    public static b EI(String str) {
        AppMethodBeat.i(77447);
        b bVar = (b) d.f(str, b.class);
        AppMethodBeat.o(77447);
        return bVar;
    }
}
