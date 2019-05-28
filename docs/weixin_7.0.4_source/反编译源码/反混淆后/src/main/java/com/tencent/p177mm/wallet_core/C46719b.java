package com.tencent.p177mm.wallet_core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5141c;

/* renamed from: com.tencent.mm.wallet_core.b */
public final class C46719b {
    private static C46719b AeS;

    public static C46719b dNA() {
        AppMethodBeat.m2504i(49006);
        if (AeS == null) {
            AeS = new C46719b();
        }
        C46719b c46719b = AeS;
        AppMethodBeat.m2505o(49006);
        return c46719b;
    }

    public static boolean dNB() {
        int i;
        AppMethodBeat.m2504i(49007);
        C5141c ll = C18624c.abi().mo17131ll("100368");
        if (ll.isValid() && "1".equals(ll.dru().get("open"))) {
            i = 1;
        } else {
            i = 0;
        }
        C4990ab.m7417i("MicroMsg.TenPaySdkAbTest", "isPwdOpen2048 %s", Integer.valueOf(i));
        if (i > 0) {
            AppMethodBeat.m2505o(49007);
            return true;
        }
        AppMethodBeat.m2505o(49007);
        return false;
    }

    public static boolean dNC() {
        int i;
        AppMethodBeat.m2504i(49008);
        C5141c ll = C18624c.abi().mo17131ll("100370");
        if (ll.isValid() && "1".equals(ll.dru().get("open"))) {
            i = 1;
        } else {
            i = 0;
        }
        C4990ab.m7417i("MicroMsg.TenPaySdkAbTest", "isOfflineOpen2048 %s", Integer.valueOf(i));
        if (i > 0) {
            AppMethodBeat.m2505o(49008);
            return true;
        }
        AppMethodBeat.m2505o(49008);
        return false;
    }
}
