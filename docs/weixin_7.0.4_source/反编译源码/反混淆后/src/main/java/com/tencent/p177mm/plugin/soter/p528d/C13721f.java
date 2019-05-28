package com.tencent.p177mm.plugin.soter.p528d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C6471cq;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.soter.d.f */
public final class C13721f extends C4884c<C6471cq> {
    private static String TAG = "MicroMsg.SoterDynamicConfigUpdatedEventListener";

    public C13721f() {
        AppMethodBeat.m2504i(59335);
        this.xxI = C6471cq.class.getName().hashCode();
        AppMethodBeat.m2505o(59335);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(59336);
        C4990ab.m7416i(TAG, "alvinluo dynamic config updated.");
        C4104m.cvR();
        AppMethodBeat.m2505o(59336);
        return true;
    }
}
