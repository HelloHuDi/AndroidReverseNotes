package com.tencent.p177mm.wallet_core.p1576f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.WeakHashMap;

/* renamed from: com.tencent.mm.wallet_core.f.a */
public final class C40939a {
    public WeakHashMap<Object, Boolean> Ags = new WeakHashMap();

    /* renamed from: com.tencent.mm.wallet_core.f.a$a */
    static class C40940a {
        static C40939a Agt = new C40939a();

        static {
            AppMethodBeat.m2504i(49162);
            AppMethodBeat.m2505o(49162);
        }
    }

    public C40939a() {
        AppMethodBeat.m2504i(49163);
        AppMethodBeat.m2505o(49163);
    }

    public static synchronized C40939a dOl() {
        C40939a c40939a;
        synchronized (C40939a.class) {
            c40939a = C40940a.Agt;
        }
        return c40939a;
    }
}
