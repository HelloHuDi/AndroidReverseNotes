package com.tencent.p177mm.plugin.appbrand.p332t.p334b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p332t.p334b.C38512a.C33527b;
import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C38514a;
import com.tencent.p177mm.plugin.appbrand.p332t.p914e.C45692b;

/* renamed from: com.tencent.mm.plugin.appbrand.t.b.c */
public class C2461c extends C33528b {
    /* renamed from: c */
    public final C33527b mo6382c(C38514a c38514a) {
        AppMethodBeat.m2504i(73246);
        C33527b c33527b;
        if (C33528b.m54752g(c38514a) == 13) {
            c33527b = C33527b.MATCHED;
            AppMethodBeat.m2505o(73246);
            return c33527b;
        }
        c33527b = C33527b.NOT_MATCHED;
        AppMethodBeat.m2505o(73246);
        return c33527b;
    }

    /* renamed from: a */
    public final C45692b mo6380a(C45692b c45692b) {
        AppMethodBeat.m2504i(73247);
        super.mo6380a(c45692b);
        c45692b.put("Sec-WebSocket-Version", "13");
        AppMethodBeat.m2505o(73247);
        return c45692b;
    }

    public C38512a aOm() {
        AppMethodBeat.m2504i(73248);
        C2461c c2461c = new C2461c();
        AppMethodBeat.m2505o(73248);
        return c2461c;
    }
}
