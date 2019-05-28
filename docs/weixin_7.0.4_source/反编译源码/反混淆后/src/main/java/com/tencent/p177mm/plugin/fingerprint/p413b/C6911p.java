package com.tencent.p177mm.plugin.fingerprint.p413b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C26240sr;
import com.tencent.p177mm.p230g.p231a.C26240sr.C26241a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.fingerprint.b.p */
public final class C6911p extends C4884c<C26240sr> {
    public C6911p() {
        AppMethodBeat.m2504i(41557);
        this.xxI = C26240sr.class.getName().hashCode();
        AppMethodBeat.m2505o(41557);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(41558);
        C26240sr c26240sr = (C26240sr) c4883b;
        if (!C1720g.m3531RK()) {
            C4990ab.m7412e("MicroMsg.SupportFingerPrintEventListener", "SupportFingerPrintEventListener account is not ready");
        } else if (c26240sr instanceof C26240sr) {
            C4990ab.m7416i("MicroMsg.SupportFingerPrintEventListener", "handle SupportFingerPrintEvent");
            boolean bxj = C39086c.bxj();
            C4990ab.m7416i("MicroMsg.SupportFingerPrintEventListener", "isSupportFP is ".concat(String.valueOf(bxj)));
            C26241a c26241a = new C26241a();
            c26241a.cOQ = bxj;
            c26240sr.cOP = c26241a;
            if (c26240sr.callback != null) {
                c26240sr.callback.run();
            }
            AppMethodBeat.m2505o(41558);
            return true;
        }
        AppMethodBeat.m2505o(41558);
        return false;
    }
}
