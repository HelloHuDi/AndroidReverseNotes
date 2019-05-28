package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p1451f.p1452a.p1453a.C32115a;

/* renamed from: com.tencent.smtt.sdk.bf */
class C24269bf implements C32115a {
    /* renamed from: a */
    final /* synthetic */ C46737be f4521a;

    C24269bf(C46737be c46737be) {
        this.f4521a = c46737be;
    }

    public void onUserStateChanged() {
        AppMethodBeat.m2504i(64622);
        this.f4521a.f18010a.mo28968c();
        AppMethodBeat.m2505o(64622);
    }
}
