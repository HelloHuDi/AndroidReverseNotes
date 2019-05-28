package com.tencent.p177mm.plugin.hardwareopt.p1405b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.asz;

/* renamed from: com.tencent.mm.plugin.hardwareopt.b.a */
public class C28285a {
    private static volatile C28285a nqq = null;
    private asz nqr = null;

    private C28285a() {
    }

    public static C28285a bFS() {
        AppMethodBeat.m2504i(59273);
        C28285a c28285a;
        if (nqq == null) {
            synchronized (C28285a.class) {
                try {
                    if (nqq == null) {
                        nqq = new C28285a();
                    }
                    c28285a = nqq;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(59273);
                }
            }
            return c28285a;
        }
        c28285a = nqq;
        AppMethodBeat.m2505o(59273);
        return c28285a;
    }

    public final asz bFT() {
        AppMethodBeat.m2504i(59274);
        if (this.nqr == null) {
            this.nqr = new asz();
        }
        asz asz = this.nqr;
        AppMethodBeat.m2505o(59274);
        return asz;
    }
}
