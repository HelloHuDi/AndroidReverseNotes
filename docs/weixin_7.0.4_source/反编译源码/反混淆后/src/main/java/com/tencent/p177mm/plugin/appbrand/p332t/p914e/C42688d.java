package com.tencent.p177mm.plugin.appbrand.p332t.p914e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.t.e.d */
public final class C42688d extends C27304g implements C45692b {
    private String iSM = "*";

    /* renamed from: Eo */
    public final void mo68091Eo(String str) {
        AppMethodBeat.m2504i(73266);
        if (str == null) {
            C4990ab.m7416i("MicroMsg.AppBrandNetWork.HandshakeImpl1Client", "http resource descriptor must not be null");
            AppMethodBeat.m2505o(73266);
            return;
        }
        this.iSM = str;
        AppMethodBeat.m2505o(73266);
    }

    public final String aOu() {
        return this.iSM;
    }
}
