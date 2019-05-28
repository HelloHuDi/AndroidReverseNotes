package com.tencent.p177mm.plugin.fingerprint.p413b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C45349oa;
import com.tencent.p177mm.plugin.fingerprint.C43094a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.fingerprint.b.k */
public final class C28048k extends C4884c<C45349oa> {
    public C28048k() {
        AppMethodBeat.m2504i(41497);
        this.xxI = C45349oa.class.getName().hashCode();
        AppMethodBeat.m2505o(41497);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(41498);
        C45349oa c45349oa = (C45349oa) c4883b;
        if (!C1720g.m3531RK()) {
            C4990ab.m7412e("MicroMsg.ReleaseFingerPrintAuthEventListener", "ReleaseFingerPrintAuthEventListener account is not ready");
        } else if (c45349oa instanceof C45349oa) {
            C4990ab.m7416i("MicroMsg.ReleaseFingerPrintAuthEventListener", "handle ReleaseFingerPrintAuthEventListener");
            C43094a.bwM();
            if (C43094a.bwN() != null) {
                C43094a.bwM();
                C43094a.bwN();
                C39086c.bxk();
                C4990ab.m7416i("MicroMsg.ReleaseFingerPrintAuthEventListener", "systemRelease FPManger");
            }
            AppMethodBeat.m2505o(41498);
            return true;
        }
        AppMethodBeat.m2505o(41498);
        return false;
    }
}
