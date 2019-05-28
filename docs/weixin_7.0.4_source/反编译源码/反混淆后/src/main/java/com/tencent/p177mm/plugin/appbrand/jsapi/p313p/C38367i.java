package com.tencent.p177mm.plugin.appbrand.jsapi.p313p;

import com.tencent.luggage.p1170a.C37384e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42467ah;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.p.i */
public final class C38367i implements C45612a {
    public static C38367i hVW = new C38367i();
    private C45612a hVX = new C333861();

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.p.i$1 */
    class C333861 implements C45612a {
        C333861() {
        }

        public final int aEN() {
            return 20;
        }

        public final int aEO() {
            return 200;
        }

        /* renamed from: a */
        public final boolean mo53859a(C2241c c2241c, C42467ah c42467ah) {
            return true;
        }
    }

    public C38367i() {
        AppMethodBeat.m2504i(126391);
        AppMethodBeat.m2505o(126391);
    }

    static {
        AppMethodBeat.m2504i(126396);
        AppMethodBeat.m2505o(126396);
    }

    private C45612a aEQ() {
        AppMethodBeat.m2504i(126392);
        C45612a c45612a;
        if (C37384e.m62985B(C45612a.class) != null) {
            c45612a = (C45612a) C37384e.m62985B(C45612a.class);
            AppMethodBeat.m2505o(126392);
            return c45612a;
        }
        c45612a = this.hVX;
        AppMethodBeat.m2505o(126392);
        return c45612a;
    }

    public final int aEN() {
        AppMethodBeat.m2504i(126393);
        int aEN = aEQ().aEN();
        AppMethodBeat.m2505o(126393);
        return aEN;
    }

    public final int aEO() {
        AppMethodBeat.m2504i(126394);
        int aEO = aEQ().aEO();
        AppMethodBeat.m2505o(126394);
        return aEO;
    }

    /* renamed from: a */
    public final boolean mo53859a(C2241c c2241c, C42467ah c42467ah) {
        AppMethodBeat.m2504i(126395);
        boolean a = aEQ().mo53859a(c2241c, c42467ah);
        AppMethodBeat.m2505o(126395);
        return a;
    }
}
