package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.bt.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.azt;
import com.tencent.mm.protocal.protobuf.bso;
import com.tencent.mm.protocal.protobuf.bsp;

@l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/jsapi/op_report/OpReportUtil;", "", "()V", "getReportIdOrThrows", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "matchNetScene", "", "requestAppID", "", "plugin-appbrand-integration_release"})
public final class c {
    public static final c hSW = new c();

    static {
        AppMethodBeat.i(134686);
        AppMethodBeat.o(134686);
    }

    private c() {
    }

    public static final boolean b(m mVar, String str) {
        Object obj = null;
        AppMethodBeat.i(134684);
        j.p(str, "requestAppID");
        q acN = mVar != null ? mVar.acN() : null;
        if (!(acN instanceof b)) {
            acN = null;
        }
        b bVar = (b) acN;
        a acz = bVar != null ? bVar.acz() : null;
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
        boolean j = j.j(obj, str);
        AppMethodBeat.o(134684);
        return j;
    }

    public static final int h(m mVar) {
        AppMethodBeat.i(134685);
        q acN = mVar != null ? mVar.acN() : null;
        if (!(acN instanceof b)) {
            acN = null;
        }
        b bVar = (b) acN;
        a acA = bVar != null ? bVar.acA() : null;
        if (!(acA instanceof bsp)) {
            acA = null;
        }
        bsp bsp = (bsp) acA;
        if (bsp != null) {
            int i = bsp.wUK;
            AppMethodBeat.o(134685);
            return i;
        }
        Throwable illegalArgumentException = new IllegalArgumentException();
        AppMethodBeat.o(134685);
        throw illegalArgumentException;
    }
}
