package com.tencent.p177mm.plugin.fingerprint.p413b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C18316lv;
import com.tencent.p177mm.pluginsdk.C30052l;
import com.tencent.p177mm.pluginsdk.C44056k;
import com.tencent.p177mm.pluginsdk.wallet.C14990c;
import com.tencent.p177mm.pluginsdk.wallet.C14992j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.fingerprint.b.c */
public final class C39086c implements C44056k {
    public static boolean bxj() {
        AppMethodBeat.m2504i(41429);
        boolean bxn = ((C30052l) C1720g.m3528K(C30052l.class)).bxn();
        C4990ab.m7416i("MicroMsg.FingerPrintAuthMgr", "isSupportFP is ".concat(String.valueOf(bxn)));
        AppMethodBeat.m2505o(41429);
        return bxn;
    }

    /* renamed from: a */
    public static int m66508a(C14990c c14990c, boolean z) {
        AppMethodBeat.m2504i(41430);
        int a = ((C30052l) C1720g.m3528K(C30052l.class)).mo48284a(c14990c, z);
        AppMethodBeat.m2505o(41430);
        return a;
    }

    public static void release() {
        AppMethodBeat.m2504i(41431);
        ((C30052l) C1720g.m3528K(C30052l.class)).bxt();
        AppMethodBeat.m2505o(41431);
    }

    public static void abort() {
        AppMethodBeat.m2504i(41432);
        ((C30052l) C1720g.m3528K(C30052l.class)).bxu();
        AppMethodBeat.m2505o(41432);
    }

    public static void bxk() {
        AppMethodBeat.m2504i(41433);
        ((C30052l) C1720g.m3528K(C30052l.class)).bxk();
        AppMethodBeat.m2505o(41433);
    }

    public static boolean bxl() {
        AppMethodBeat.m2504i(41434);
        boolean bxo = ((C30052l) C1720g.m3528K(C30052l.class)).bxo();
        AppMethodBeat.m2505o(41434);
        return bxo;
    }

    /* renamed from: a */
    public static void m66509a(C18316lv c18316lv, int i, String str) {
        AppMethodBeat.m2504i(41435);
        ((C30052l) C1720g.m3528K(C30052l.class)).mo48286a(c18316lv, i, str);
        AppMethodBeat.m2505o(41435);
    }

    public static C14992j bxm() {
        AppMethodBeat.m2504i(41436);
        C14992j bxm = ((C30052l) C1720g.m3528K(C30052l.class)).bxm();
        AppMethodBeat.m2505o(41436);
        return bxm;
    }
}
