package com.tencent.p177mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1918k;

/* renamed from: com.tencent.mm.model.bi */
public final class C1833bi {
    public static C1832a fmO = null;

    /* renamed from: com.tencent.mm.model.bi$a */
    public interface C1832a {
        int aag();

        C1918k aah();
    }

    /* renamed from: a */
    public static C1918k m3777a(C1918k c1918k) {
        AppMethodBeat.m2504i(58107);
        if (fmO == null) {
            AppMethodBeat.m2505o(58107);
            return c1918k;
        }
        c1918k = fmO.aah();
        AppMethodBeat.m2505o(58107);
        return c1918k;
    }

    public static int aag() {
        AppMethodBeat.m2504i(58108);
        if (fmO != null) {
            int aag = fmO.aag();
            AppMethodBeat.m2505o(58108);
            return aag;
        }
        AppMethodBeat.m2505o(58108);
        return 0;
    }
}
