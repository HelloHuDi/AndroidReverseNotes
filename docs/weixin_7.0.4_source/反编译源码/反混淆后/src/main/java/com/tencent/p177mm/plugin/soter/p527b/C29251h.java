package com.tencent.p177mm.plugin.soter.p527b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.soter.p528d.C46261a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.soter.p663a.p1106b.C16164b;
import com.tencent.soter.p663a.p1106b.C16165c;
import com.tencent.soter.p663a.p1106b.C46744e;

/* renamed from: com.tencent.mm.plugin.soter.b.h */
public final class C29251h {
    C29250a rNI;
    int rNJ = -3201;

    /* renamed from: com.tencent.mm.plugin.soter.b.h$1 */
    class C168681 implements C16164b<C16165c> {
        C168681() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo17330a(C46744e c46744e) {
            AppMethodBeat.m2504i(59318);
            C16165c c16165c = (C16165c) c46744e;
            C4990ab.m7417i("MicroMsg.SoterNetDelegateUtil", "generate and upload ask onResult errCode: %d, errMsg: %s", Integer.valueOf(c16165c.errCode), c16165c.aIm);
            if (!c16165c.isSuccess()) {
                C46261a.m86642fH(1, c16165c.errCode);
                if (C29251h.this.rNI != null) {
                    C29251h.this.rNI.mo47426EA(c16165c.errCode);
                }
            } else if (C29251h.this.rNI != null) {
                C29251h.this.rNI.cvF();
                AppMethodBeat.m2505o(59318);
                return;
            }
            AppMethodBeat.m2505o(59318);
        }
    }

    public C29251h(C29250a c29250a) {
        this.rNI = c29250a;
    }
}
