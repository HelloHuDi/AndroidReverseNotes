package com.tencent.p177mm.plugin.fingerprint.p413b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.fingerprint.b.q */
public final class C3114q {
    C3116a msf;

    /* renamed from: com.tencent.mm.plugin.fingerprint.b.q$1 */
    class C31151 implements Runnable {
        C31151() {
        }

        public final void run() {
            AppMethodBeat.m2504i(41559);
            String str = "";
            if (C39088e.bxs()) {
                C4990ab.m7416i("MicroMsg.SyncGenRsaKey", "device is support FingerPrintAuth");
                str = FingerPrintAuth.genRsaKey(C39088e.m66512dQ(C4996ah.getContext()), C39088e.getUserId(), C1427q.m3028LM());
            } else {
                C4990ab.m7412e("MicroMsg.SyncGenRsaKey", "device is not support FingerPrintAuth");
            }
            if (C3114q.this.msf != null) {
                C3114q.this.msf.mo7360AR(str);
            }
            AppMethodBeat.m2505o(41559);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fingerprint.b.q$a */
    public interface C3116a {
        /* renamed from: AR */
        void mo7360AR(String str);
    }

    public C3114q(C3116a c3116a) {
        this.msf = c3116a;
    }

    public final void aBU() {
        AppMethodBeat.m2504i(41560);
        C7305d.post(new C31151(), getClass().getName());
        AppMethodBeat.m2505o(41560);
    }
}
