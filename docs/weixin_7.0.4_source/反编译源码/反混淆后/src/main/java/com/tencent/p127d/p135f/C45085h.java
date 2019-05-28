package com.tencent.p127d.p135f;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.d.f.h */
public final class C45085h {
    private static boolean Auy;
    private static C37321g Auz;

    static {
        AppMethodBeat.m2504i(114620);
        Auy = false;
        Auz = new C8770k();
        Auy = false;
        Auz = new C8770k();
        AppMethodBeat.m2505o(114620);
    }

    /* renamed from: w */
    public static void m82713w(Throwable th) {
        AppMethodBeat.m2504i(114617);
        C45085h.m82711db(th);
        AppMethodBeat.m2505o(114617);
    }

    /* renamed from: db */
    public static void m82711db(Object obj) {
        AppMethodBeat.m2504i(114618);
        if (obj == null || !(obj instanceof Exception)) {
            AppMethodBeat.m2505o(114618);
            return;
        }
        new StringBuilder().append(obj);
        AppMethodBeat.m2505o(114618);
    }

    /* renamed from: dc */
    public static void m82712dc(Object obj) {
        AppMethodBeat.m2504i(114619);
        if (obj == null || !(obj instanceof Exception)) {
            AppMethodBeat.m2505o(114619);
            return;
        }
        new StringBuilder().append(obj);
        AppMethodBeat.m2505o(114619);
    }

    public static void dQG() {
    }

    public static void dQH() {
    }

    public static void dQI() {
    }
}
