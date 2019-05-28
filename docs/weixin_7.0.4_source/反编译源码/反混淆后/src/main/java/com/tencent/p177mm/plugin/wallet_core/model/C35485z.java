package com.tencent.p177mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.z */
public final class C35485z {
    public static String TAG = "MicroMsg.WalletIndexPayMenu";

    public static void acA(String str) {
        AppMethodBeat.m2504i(46909);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_INDEX_MAIDAN_STRING_SYNC, (Object) str);
        AppMethodBeat.m2505o(46909);
    }
}
