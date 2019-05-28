package com.google.firebase.p1522b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.firebase.b.b */
public final class C37301b {
    private static final AtomicReference<C37301b> buH = new AtomicReference();

    static {
        AppMethodBeat.m2504i(10636);
        AppMethodBeat.m2505o(10636);
    }

    private C37301b() {
    }

    /* renamed from: uY */
    public static C37301b m62703uY() {
        AppMethodBeat.m2504i(10635);
        buH.compareAndSet(null, new C37301b());
        C37301b c37301b = (C37301b) buH.get();
        AppMethodBeat.m2505o(10635);
        return c37301b;
    }

    /* renamed from: uZ */
    public static void m62704uZ() {
    }
}
