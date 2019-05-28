package com.tencent.p177mm.plugin.appbrand.widget.input.p341d;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.d.b */
public enum C33624b {
    DONE(6),
    SEARCH(3),
    NEXT(5),
    GO(2),
    SEND(4);
    
    public final int jjd;

    static {
        AppMethodBeat.m2505o(77448);
    }

    private C33624b(int i) {
        this.jjd = i;
    }

    public static C33624b aRI() {
        return DONE;
    }

    /* renamed from: EI */
    public static C33624b m54895EI(String str) {
        AppMethodBeat.m2504i(77447);
        C33624b c33624b = (C33624b) C33626d.m54899f(str, C33624b.class);
        AppMethodBeat.m2505o(77447);
        return c33624b;
    }
}
