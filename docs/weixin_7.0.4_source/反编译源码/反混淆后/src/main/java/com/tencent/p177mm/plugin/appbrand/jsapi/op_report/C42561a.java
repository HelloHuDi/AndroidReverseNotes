package com.tencent.p177mm.plugin.appbrand.jsapi.op_report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38369p;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.op_report.a */
final class C42561a extends C38369p {
    private static final int CTRL_INDEX = 246;
    private static final String NAME = "onStartReportPageData";
    private static final C42561a hSU = new C42561a();

    C42561a() {
    }

    /* renamed from: k */
    static synchronized void m75358k(C2241c c2241c) {
        synchronized (C42561a.class) {
            AppMethodBeat.m2504i(102003);
            hSU.mo61031i(c2241c).aCj();
            AppMethodBeat.m2505o(102003);
        }
    }

    static {
        AppMethodBeat.m2504i(102004);
        AppMethodBeat.m2505o(102004);
    }
}
