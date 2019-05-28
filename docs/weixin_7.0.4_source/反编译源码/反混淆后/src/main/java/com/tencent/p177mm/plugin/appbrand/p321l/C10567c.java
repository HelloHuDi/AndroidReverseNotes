package com.tencent.p177mm.plugin.appbrand.p321l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.tencent.mm.plugin.appbrand.l.c */
public final class C10567c {
    private static AtomicInteger ioy = new AtomicInteger(1);
    public HashMap<String, C27146b> hGk;

    /* renamed from: com.tencent.mm.plugin.appbrand.l.c$a */
    static class C10568a {
        private static C10567c ioz = new C10567c();

        static {
            AppMethodBeat.m2504i(108142);
            AppMethodBeat.m2505o(108142);
        }
    }

    /* synthetic */ C10567c(byte b) {
        this();
    }

    static {
        AppMethodBeat.m2504i(108147);
        AppMethodBeat.m2505o(108147);
    }

    private C10567c() {
        AppMethodBeat.m2504i(108143);
        this.hGk = new HashMap();
        AppMethodBeat.m2505o(108143);
    }

    public static int aIA() {
        AppMethodBeat.m2504i(108144);
        int incrementAndGet = ioy.incrementAndGet();
        AppMethodBeat.m2505o(108144);
        return incrementAndGet;
    }

    public static C10567c aIB() {
        AppMethodBeat.m2504i(108145);
        C10567c aIC = C10568a.ioz;
        AppMethodBeat.m2505o(108145);
        return aIC;
    }

    /* renamed from: CJ */
    public final C27146b mo22076CJ(String str) {
        AppMethodBeat.m2504i(108146);
        if (this.hGk.containsKey(str)) {
            C27146b c27146b = (C27146b) this.hGk.get(str);
            AppMethodBeat.m2505o(108146);
            return c27146b;
        }
        AppMethodBeat.m2505o(108146);
        return null;
    }
}
