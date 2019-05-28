package com.tencent.p177mm.plugin.expt.p395c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5018as;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.expt.c.b */
public final class C38985b {
    private static C38985b lNR;
    private String name = null;

    public static C38985b bqZ() {
        AppMethodBeat.m2504i(73524);
        if (lNR == null) {
            lNR = new C38985b();
        }
        C38985b c38985b = lNR;
        AppMethodBeat.m2505o(73524);
        return c38985b;
    }

    private C38985b() {
    }

    /* Access modifiers changed, original: final */
    public final C5018as bra() {
        AppMethodBeat.m2504i(73525);
        int Ra = C1668a.m3396Ra();
        if (Ra == 0) {
            AppMethodBeat.m2505o(73525);
            return null;
        }
        String str = Ra + "_WxPageFlow";
        if (!C5046bo.isEqual(this.name, str)) {
            C4990ab.m7417i("MicroMsg.MMPageFlowMMKV", "get mmkv change uin old[%s] new[%s]", this.name, str);
            this.name = str;
        }
        C5018as amF = C5018as.amF(this.name);
        AppMethodBeat.m2505o(73525);
        return amF;
    }

    public final void remove(String str) {
        AppMethodBeat.m2504i(73526);
        C5018as bra = bra();
        if (bra == null) {
            AppMethodBeat.m2505o(73526);
            return;
        }
        bra.remove(str);
        AppMethodBeat.m2505o(73526);
    }

    public final String get(String str, String str2) {
        AppMethodBeat.m2504i(73527);
        C5018as bra = bra();
        if (bra == null) {
            AppMethodBeat.m2505o(73527);
            return str2;
        }
        str2 = bra.getString(str, str2);
        AppMethodBeat.m2505o(73527);
        return str2;
    }

    public final String[] allKeys() {
        AppMethodBeat.m2504i(73528);
        C5018as bra = bra();
        if (bra == null) {
            AppMethodBeat.m2505o(73528);
            return null;
        }
        String[] allKeys = bra.allKeys();
        AppMethodBeat.m2505o(73528);
        return allKeys;
    }
}
