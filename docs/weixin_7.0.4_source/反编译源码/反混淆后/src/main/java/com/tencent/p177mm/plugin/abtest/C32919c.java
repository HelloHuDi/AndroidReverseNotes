package com.tencent.p177mm.plugin.abtest;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.model.p262c.C18624c;

/* renamed from: com.tencent.mm.plugin.abtest.c */
public final class C32919c extends C7485q {
    private static C32919c gpO;

    private C32919c() {
        super(C18624c.class);
    }

    public static synchronized C32919c aoN() {
        C32919c c32919c;
        synchronized (C32919c.class) {
            AppMethodBeat.m2504i(118192);
            if (gpO == null) {
                gpO = new C32919c();
            }
            c32919c = gpO;
            AppMethodBeat.m2505o(118192);
        }
        return c32919c;
    }

    /* renamed from: lM */
    public final void mo5175lM(String str) {
        AppMethodBeat.m2504i(118193);
        super.mo5175lM(str);
        AppMethodBeat.m2505o(118193);
    }
}
