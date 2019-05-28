package com.tencent.p177mm.plugin.appbrand.p321l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.tencent.mm.plugin.appbrand.l.f */
public final class C42598f {
    private static AtomicInteger ioy = new AtomicInteger(1);
    public HashMap<String, C33422d> hGk;

    /* renamed from: com.tencent.mm.plugin.appbrand.l.f$a */
    static class C2357a {
        private static C42598f ioS = new C42598f();

        static {
            AppMethodBeat.m2504i(108161);
            AppMethodBeat.m2505o(108161);
        }
    }

    /* synthetic */ C42598f(byte b) {
        this();
    }

    static {
        AppMethodBeat.m2504i(108166);
        AppMethodBeat.m2505o(108166);
    }

    private C42598f() {
        AppMethodBeat.m2504i(108162);
        this.hGk = new HashMap();
        AppMethodBeat.m2505o(108162);
    }

    public static int aIA() {
        AppMethodBeat.m2504i(108163);
        int incrementAndGet = ioy.incrementAndGet();
        AppMethodBeat.m2505o(108163);
        return incrementAndGet;
    }

    public static C42598f aIE() {
        AppMethodBeat.m2504i(108164);
        C42598f aIF = C2357a.ioS;
        AppMethodBeat.m2505o(108164);
        return aIF;
    }

    /* renamed from: CM */
    public final C33422d mo68030CM(String str) {
        AppMethodBeat.m2504i(108165);
        if (this.hGk.containsKey(str)) {
            C33422d c33422d = (C33422d) this.hGk.get(str);
            AppMethodBeat.m2505o(108165);
            return c33422d;
        }
        AppMethodBeat.m2505o(108165);
        return null;
    }
}
