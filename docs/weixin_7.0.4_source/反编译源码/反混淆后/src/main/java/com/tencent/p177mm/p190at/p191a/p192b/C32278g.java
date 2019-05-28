package com.tencent.p177mm.p190at.p191a.p192b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p190at.p191a.p1527d.C45159a;
import com.tencent.p177mm.p190at.p191a.p193c.C37476n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.at.a.b.g */
public final class C32278g implements C37476n {
    private C45159a<String, Integer> fHo = new C45159a(10);

    public C32278g() {
        AppMethodBeat.m2504i(116093);
        AppMethodBeat.m2505o(116093);
    }

    /* renamed from: sG */
    public final synchronized boolean mo52983sG(String str) {
        boolean z;
        AppMethodBeat.m2504i(116094);
        if (this.fHo.mo73069aj(str)) {
            int intValue = ((Integer) this.fHo.get(str)).intValue();
            this.fHo.put(str, Integer.valueOf(intValue + 1));
            if (intValue >= 50) {
                if (intValue == 50 || intValue % 500 == 0) {
                    C4990ab.m7417i("MicroMsg.imageloader.DefaultImageRetryDownloadListener", "Url %s retry over time %d current time:%d, then stop retry download", str, Integer.valueOf(50), Integer.valueOf(intValue));
                }
                AppMethodBeat.m2505o(116094);
                z = false;
            }
            AppMethodBeat.m2505o(116094);
            z = true;
        } else {
            this.fHo.put(str, Integer.valueOf(1));
            AppMethodBeat.m2505o(116094);
            z = true;
        }
        return z;
    }
}
