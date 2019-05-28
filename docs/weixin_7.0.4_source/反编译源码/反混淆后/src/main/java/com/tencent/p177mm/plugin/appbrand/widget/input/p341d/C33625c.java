package com.tencent.p177mm.plugin.appbrand.widget.input.p341d;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.d.c */
public enum C33625c {
    NORMAL(0),
    BOLD(1);
    
    public final int style;

    static {
        AppMethodBeat.m2505o(77452);
    }

    private C33625c(int i) {
        this.style = i;
    }

    /* renamed from: EJ */
    public static C33625c m54896EJ(String str) {
        AppMethodBeat.m2504i(77451);
        Enum f = C33626d.m54899f(str, C33625c.class);
        C33625c c33625c = NORMAL;
        if (f != null) {
            Enum c33625c2 = f;
        }
        c33625c2 = c33625c2;
        AppMethodBeat.m2505o(77451);
        return c33625c2;
    }
}
