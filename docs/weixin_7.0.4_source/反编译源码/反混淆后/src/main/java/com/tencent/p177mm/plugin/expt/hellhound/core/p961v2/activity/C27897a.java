package com.tencent.p177mm.plugin.expt.hellhound.core.p961v2.activity;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.expt.hellhound.core.p961v2.activity.p1547a.C38989b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a */
public final class C27897a {
    /* renamed from: KO */
    static void m44360KO(String str) {
        AppMethodBeat.m2504i(73388);
        C4990ab.m7416i("ActivityActionWrapper", "habbyge-mali, setFinishAction_resume: ".concat(String.valueOf(str)));
        C38989b.bqC().lMN.mo73730KO(str);
        AppMethodBeat.m2505o(73388);
    }

    /* renamed from: KP */
    static void m44361KP(String str) {
        AppMethodBeat.m2504i(73389);
        C4990ab.m7416i("ActivityActionWrapper", "habbyge-mali, setFinishAction_pause: ".concat(String.valueOf(str)));
        C38989b.bqC().lMN.mo73731KP(str);
        AppMethodBeat.m2505o(73389);
    }

    /* renamed from: uX */
    public static void m44362uX(int i) {
        AppMethodBeat.m2504i(73390);
        C4990ab.m7410d("ActivityActionWrapper", "habbyge-mali, setActivityMethod: ".concat(String.valueOf(i)));
        C38989b.bqC().lMN.mo73740uX(i);
        AppMethodBeat.m2505o(73390);
    }

    public static int bqA() {
        AppMethodBeat.m2504i(73391);
        int bqA = C38989b.bqC().lMN.bqA();
        AppMethodBeat.m2505o(73391);
        return bqA;
    }
}
