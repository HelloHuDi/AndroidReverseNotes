package com.tencent.p177mm.plugin.appbrand.p329s;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.s.j */
public final class C42678j {
    private long iRu;
    private long iRv;
    private C42679a iRw;

    /* renamed from: com.tencent.mm.plugin.appbrand.s.j$a */
    public interface C42679a {
        /* renamed from: j */
        boolean mo6217j(Object... objArr);
    }

    public C42678j(long j, C42679a c42679a) {
        this.iRu = j;
        this.iRw = c42679a;
    }

    private boolean aOa() {
        AppMethodBeat.m2504i(126636);
        if (System.currentTimeMillis() - this.iRv < this.iRu) {
            AppMethodBeat.m2505o(126636);
            return true;
        }
        AppMethodBeat.m2505o(126636);
        return false;
    }

    /* renamed from: l */
    public final boolean mo68088l(Object... objArr) {
        boolean z = false;
        AppMethodBeat.m2504i(126637);
        if (aOa()) {
            AppMethodBeat.m2505o(126637);
        } else if (this.iRw == null) {
            AppMethodBeat.m2505o(126637);
        } else {
            z = this.iRw.mo6217j(objArr);
            if (z) {
                this.iRv = System.currentTimeMillis();
            }
            AppMethodBeat.m2505o(126637);
        }
        return z;
    }
}
