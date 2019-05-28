package com.tencent.p177mm.plugin.appbrand.p321l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.tencent.mm.plugin.appbrand.l.i */
public final class C42601i {
    private static AtomicInteger ioy = new AtomicInteger(1);
    public HashMap<String, C42599g> hGk;

    /* renamed from: com.tencent.mm.plugin.appbrand.l.i$a */
    static class C27149a {
        private static C42601i ioZ = new C42601i();

        static {
            AppMethodBeat.m2504i(108180);
            AppMethodBeat.m2505o(108180);
        }
    }

    /* synthetic */ C42601i(byte b) {
        this();
    }

    static {
        AppMethodBeat.m2504i(108185);
        AppMethodBeat.m2505o(108185);
    }

    private C42601i() {
        AppMethodBeat.m2504i(108181);
        this.hGk = new HashMap();
        AppMethodBeat.m2505o(108181);
    }

    public static int aIA() {
        AppMethodBeat.m2504i(108182);
        int incrementAndGet = ioy.incrementAndGet();
        AppMethodBeat.m2505o(108182);
        return incrementAndGet;
    }

    public static C42601i aIG() {
        AppMethodBeat.m2504i(108183);
        C42601i aIH = C27149a.ioZ;
        AppMethodBeat.m2505o(108183);
        return aIH;
    }

    /* renamed from: CO */
    public final C42599g mo68036CO(String str) {
        AppMethodBeat.m2504i(108184);
        if (this.hGk.containsKey(str)) {
            C42599g c42599g = (C42599g) this.hGk.get(str);
            AppMethodBeat.m2505o(108184);
            return c42599g;
        }
        AppMethodBeat.m2505o(108184);
        return null;
    }
}
