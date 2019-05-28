package com.tencent.p177mm.plugin.expt.hellhound;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.expt.p1257e.C27892c;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.pointers.PBool;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.expt.hellhound.a */
public final class C11755a {
    private static PBool lMf = null;
    private static PBool lMg = null;
    private static PBool lMh = null;
    private static PBool lMi = null;

    public static boolean bqj() {
        AppMethodBeat.m2504i(73323);
        if (lMf == null) {
            C27892c.bru();
            String a = C27892c.m44337a(C11745a.clicfg_hellhound_switch, "", false);
            PBool pBool = new PBool();
            lMf = pBool;
            pBool.value = C5046bo.getInt(a, 0) > 0;
        }
        C4990ab.m7417i("HellhoundConfig", "habbyge-mali, HellhoundConfig, hellhoundSwitch: [%b]", Boolean.valueOf(lMf.value));
        boolean z = lMf.value;
        AppMethodBeat.m2505o(73323);
        return z;
    }

    public static boolean bqk() {
        AppMethodBeat.m2504i(73324);
        if (lMg == null) {
            C27892c.bru();
            String a = C27892c.m44337a(C11745a.clicfg_hellhound_frontback_switch, "", false);
            PBool pBool = new PBool();
            lMg = pBool;
            pBool.value = C5046bo.getInt(a, 0) > 0;
        }
        C4990ab.m7417i("HellhoundConfig", "habbyge-mali, HellhoundConfig, frongbackSwitch: [%b]", Boolean.valueOf(lMg.value));
        boolean z = lMg.value;
        AppMethodBeat.m2505o(73324);
        return z;
    }

    public static boolean bql() {
        boolean z = false;
        AppMethodBeat.m2504i(73325);
        if (lMi == null) {
            C27892c.bru();
            String a = C27892c.m44337a(C11745a.clicfg_hellhound_timeline_switch, "", false);
            PBool pBool = new PBool();
            lMi = pBool;
            if (C5046bo.getInt(a, 0) > 0) {
                z = true;
            }
            pBool.value = z;
        }
        z = lMi.value;
        AppMethodBeat.m2505o(73325);
        return z;
    }
}
