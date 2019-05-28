package com.tencent.p177mm.wallet_core.p649c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.wallet_core.c.ad */
public final class C44422ad {
    /* renamed from: o */
    public static void m80307o(int i, String str, int i2) {
        AppMethodBeat.m2504i(49100);
        C4990ab.m7419v("Micromsg.WalletPayLinkReport", "kvStatStartPay scene %s reqKey %s errcode %s", Integer.valueOf(i), str, Integer.valueOf(i2));
        C7060h.pYm.mo8381e(14997, Integer.valueOf(i), str, Integer.valueOf(i2));
        AppMethodBeat.m2505o(49100);
    }

    /* renamed from: e */
    public static void m80306e(int i, String str, int i2, String str2) {
        AppMethodBeat.m2504i(49101);
        C4990ab.m7419v("Micromsg.WalletPayLinkReport", "kvAction scene %s reqKey %s action %s info %s", Integer.valueOf(i), str, Integer.valueOf(i2), str2);
        C7060h.pYm.mo8381e(15001, Integer.valueOf(i), str, Integer.valueOf(i2), str2);
        AppMethodBeat.m2505o(49101);
    }
}
