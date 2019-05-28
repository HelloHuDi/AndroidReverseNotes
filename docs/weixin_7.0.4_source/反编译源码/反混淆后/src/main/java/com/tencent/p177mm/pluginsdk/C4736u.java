package com.tencent.p177mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.pluginsdk.u */
public final class C4736u {
    private static boolean vaB = false;
    public String mTag = "";
    public boolean vaA = false;

    public C4736u(String str) {
        this.mTag = str;
    }

    public static void dgS() {
        vaB = true;
    }

    /* renamed from: cM */
    public final boolean mo9879cM(String str) {
        AppMethodBeat.m2504i(105838);
        if (vaB) {
            C4990ab.m7417i("MicroMsg.SplashOptimizing", "[%s], check cancel", this.mTag);
            AppMethodBeat.m2505o(105838);
            return false;
        } else if (this.vaA) {
            C4990ab.m7417i("MicroMsg.SplashOptimizing", "[%s], recreate activity, skip this %s", this.mTag, str);
            AppMethodBeat.m2505o(105838);
            return true;
        } else {
            AppMethodBeat.m2505o(105838);
            return false;
        }
    }
}
