package com.tencent.p177mm.plugin.appbrand.jsapi.op_report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.protocal.protobuf.azt;
import com.tencent.p177mm.protocal.protobuf.bso;
import com.tencent.p177mm.protocal.protobuf.bsp;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/op_report/OpReportUtil;", "", "()V", "getReportIdOrThrows", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "matchNetScene", "", "requestAppID", "", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.op_report.c */
public final class C19464c {
    public static final C19464c hSW = new C19464c();

    static {
        AppMethodBeat.m2504i(134686);
        AppMethodBeat.m2505o(134686);
    }

    private C19464c() {
    }

    /* renamed from: b */
    public static final boolean m30140b(C1207m c1207m, String str) {
        Object obj = null;
        AppMethodBeat.m2504i(134684);
        C25052j.m39376p(str, "requestAppID");
        C1929q acN = c1207m != null ? c1207m.acN() : null;
        if (!(acN instanceof C7472b)) {
            acN = null;
        }
        C7472b c7472b = (C7472b) acN;
        C1331a acz = c7472b != null ? c7472b.acz() : null;
        if (!(acz instanceof bso)) {
            acz = null;
        }
        bso bso = (bso) acz;
        if (bso != null) {
            azt azt = bso.wUJ;
            if (azt != null) {
                obj = azt.csB;
            }
        }
        boolean j = C25052j.m39373j(obj, str);
        AppMethodBeat.m2505o(134684);
        return j;
    }

    /* renamed from: h */
    public static final int m30141h(C1207m c1207m) {
        AppMethodBeat.m2504i(134685);
        C1929q acN = c1207m != null ? c1207m.acN() : null;
        if (!(acN instanceof C7472b)) {
            acN = null;
        }
        C7472b c7472b = (C7472b) acN;
        C1331a acA = c7472b != null ? c7472b.acA() : null;
        if (!(acA instanceof bsp)) {
            acA = null;
        }
        bsp bsp = (bsp) acA;
        if (bsp != null) {
            int i = bsp.wUK;
            AppMethodBeat.m2505o(134685);
            return i;
        }
        Throwable illegalArgumentException = new IllegalArgumentException();
        AppMethodBeat.m2505o(134685);
        throw illegalArgumentException;
    }
}
