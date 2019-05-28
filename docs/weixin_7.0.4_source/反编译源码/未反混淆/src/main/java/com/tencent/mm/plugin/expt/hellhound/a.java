package com.tencent.mm.plugin.expt.hellhound;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.e.c;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class a {
    private static PBool lMf = null;
    private static PBool lMg = null;
    private static PBool lMh = null;
    private static PBool lMi = null;

    public static boolean bqj() {
        AppMethodBeat.i(73323);
        if (lMf == null) {
            c.bru();
            String a = c.a(com.tencent.mm.plugin.expt.a.a.a.clicfg_hellhound_switch, "", false);
            PBool pBool = new PBool();
            lMf = pBool;
            pBool.value = bo.getInt(a, 0) > 0;
        }
        ab.i("HellhoundConfig", "habbyge-mali, HellhoundConfig, hellhoundSwitch: [%b]", Boolean.valueOf(lMf.value));
        boolean z = lMf.value;
        AppMethodBeat.o(73323);
        return z;
    }

    public static boolean bqk() {
        AppMethodBeat.i(73324);
        if (lMg == null) {
            c.bru();
            String a = c.a(com.tencent.mm.plugin.expt.a.a.a.clicfg_hellhound_frontback_switch, "", false);
            PBool pBool = new PBool();
            lMg = pBool;
            pBool.value = bo.getInt(a, 0) > 0;
        }
        ab.i("HellhoundConfig", "habbyge-mali, HellhoundConfig, frongbackSwitch: [%b]", Boolean.valueOf(lMg.value));
        boolean z = lMg.value;
        AppMethodBeat.o(73324);
        return z;
    }

    public static boolean bql() {
        boolean z = false;
        AppMethodBeat.i(73325);
        if (lMi == null) {
            c.bru();
            String a = c.a(com.tencent.mm.plugin.expt.a.a.a.clicfg_hellhound_timeline_switch, "", false);
            PBool pBool = new PBool();
            lMi = pBool;
            if (bo.getInt(a, 0) > 0) {
                z = true;
            }
            pBool.value = z;
        }
        z = lMi.value;
        AppMethodBeat.o(73325);
        return z;
    }
}
