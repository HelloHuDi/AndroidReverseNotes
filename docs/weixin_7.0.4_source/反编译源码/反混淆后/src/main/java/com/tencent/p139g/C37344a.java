package com.tencent.p139g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p139g.p1166b.C17759a;

/* renamed from: com.tencent.g.a */
public final class C37344a implements C17759a {
    private C0940g AHy;
    private boolean alP = true;

    protected C37344a(C0940g c0940g) {
        this.AHy = c0940g;
    }

    /* renamed from: t */
    public final void mo32841t(String str, Object obj) {
        AppMethodBeat.m2504i(127741);
        if (this.alP) {
            C0938f dSG = C0938f.dSG();
            if (obj == null) {
                C0941h c0941h = new C0941h("TpfServiceCenter|registerService|name or service should not be null");
                AppMethodBeat.m2505o(127741);
                throw c0941h;
            }
            synchronized (dSG.AHE) {
                try {
                    dSG.AHC.put(str, obj);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(127741);
                }
            }
            return;
        }
        AppMethodBeat.m2505o(127741);
    }
}
