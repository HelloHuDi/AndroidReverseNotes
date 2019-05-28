package com.tencent.p177mm.plugin.soter.p528d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C32570hs;
import com.tencent.p177mm.p230g.p231a.C32570hs.C9375b;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.soter.core.C40997a;

/* renamed from: com.tencent.mm.plugin.soter.d.b */
public final class C39854b extends C4884c<C32570hs> {
    public C39854b() {
        AppMethodBeat.m2504i(59329);
        this.xxI = C32570hs.class.getName().hashCode();
        AppMethodBeat.m2505o(59329);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        int i = 1;
        AppMethodBeat.m2504i(59330);
        C32570hs c32570hs = (C32570hs) c4883b;
        C4990ab.m7417i("MicroMsg.GetIsEnrolledListener", "hy: check mode: %d", Integer.valueOf(c32570hs.cCD.cCF));
        if (c32570hs.cCD.cCF == 1 && C4104m.cvU()) {
            C4990ab.m7417i("MicroMsg.GetIsEnrolledListener", "hy: has enrolled fingerprint: %b", Boolean.valueOf(C40997a.m71099iR(C4996ah.getContext())));
            C9375b c9375b = c32570hs.cCE;
            if (!C40997a.m71099iR(C4996ah.getContext())) {
                i = 0;
            }
            c9375b.cCG = i;
        } else {
            C4990ab.m7420w("MicroMsg.GetIsEnrolledListener", "hy: not support");
            c32570hs.cCE.cCG = -1;
        }
        AppMethodBeat.m2505o(59330);
        return false;
    }
}
