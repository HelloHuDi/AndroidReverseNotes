package com.tencent.p177mm.plugin.appbrand.p321l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.websocket.C10562d;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.tencent.mm.plugin.appbrand.l.l */
public final class C19546l {
    private static AtomicInteger ioy = new AtomicInteger(1);
    public HashMap<String, C10562d> hGk;

    /* renamed from: com.tencent.mm.plugin.appbrand.l.l$a */
    static class C19547a {
        private static C19546l ipf = new C19546l();

        static {
            AppMethodBeat.m2504i(108237);
            AppMethodBeat.m2505o(108237);
        }
    }

    /* synthetic */ C19546l(byte b) {
        this();
    }

    static {
        AppMethodBeat.m2504i(108242);
        AppMethodBeat.m2505o(108242);
    }

    private C19546l() {
        AppMethodBeat.m2504i(108238);
        this.hGk = new HashMap();
        AppMethodBeat.m2505o(108238);
    }

    public static C19546l aII() {
        AppMethodBeat.m2504i(108239);
        C19546l aIJ = C19547a.ipf;
        AppMethodBeat.m2505o(108239);
        return aIJ;
    }

    /* renamed from: CT */
    public final C10562d mo34742CT(String str) {
        AppMethodBeat.m2504i(108240);
        if (this.hGk.containsKey(str)) {
            C10562d c10562d = (C10562d) this.hGk.get(str);
            AppMethodBeat.m2505o(108240);
            return c10562d;
        }
        AppMethodBeat.m2505o(108240);
        return null;
    }

    public static int aIA() {
        AppMethodBeat.m2504i(108241);
        int incrementAndGet = ioy.incrementAndGet();
        AppMethodBeat.m2505o(108241);
        return incrementAndGet;
    }
}
