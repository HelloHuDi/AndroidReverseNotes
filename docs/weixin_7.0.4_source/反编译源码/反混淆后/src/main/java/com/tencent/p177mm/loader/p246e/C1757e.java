package com.tencent.p177mm.loader.p246e;

import com.tencent.p177mm.loader.p1197h.C42160d;
import com.tencent.p177mm.loader.p1197h.p1198a.C42156a;
import com.tencent.p177mm.loader.p245d.C32729e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.loader.e.e */
public final class C1757e implements C32729e {
    private C42160d<String, Integer> eQt = new C42160d(10);

    /* renamed from: a */
    public final synchronized boolean mo5291a(C42156a<?> c42156a) {
        boolean z;
        if (this.eQt.mo67701aj(c42156a.toString())) {
            int intValue = ((Integer) this.eQt.get(c42156a.toString())).intValue();
            this.eQt.put(c42156a.toString(), Integer.valueOf(intValue + 1));
            if (intValue >= 50) {
                if (intValue == 50 || intValue % 500 == 0) {
                    C4990ab.m7417i("MicroMsg.Loader.DefaultImageRetryDownloadListener", "Url %s retry over time %d current time:%d, then stop retry download", c42156a, Integer.valueOf(50), Integer.valueOf(intValue));
                }
                z = false;
            }
            z = true;
        } else {
            this.eQt.put(c42156a.toString(), Integer.valueOf(1));
            z = true;
        }
        return z;
    }
}
