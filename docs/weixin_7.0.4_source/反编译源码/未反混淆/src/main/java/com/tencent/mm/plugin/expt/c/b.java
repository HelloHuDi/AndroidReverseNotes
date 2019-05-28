package com.tencent.mm.plugin.expt.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bo;

public final class b {
    private static b lNR;
    private String name = null;

    public static b bqZ() {
        AppMethodBeat.i(73524);
        if (lNR == null) {
            lNR = new b();
        }
        b bVar = lNR;
        AppMethodBeat.o(73524);
        return bVar;
    }

    private b() {
    }

    /* Access modifiers changed, original: final */
    public final as bra() {
        AppMethodBeat.i(73525);
        int Ra = a.Ra();
        if (Ra == 0) {
            AppMethodBeat.o(73525);
            return null;
        }
        String str = Ra + "_WxPageFlow";
        if (!bo.isEqual(this.name, str)) {
            ab.i("MicroMsg.MMPageFlowMMKV", "get mmkv change uin old[%s] new[%s]", this.name, str);
            this.name = str;
        }
        as amF = as.amF(this.name);
        AppMethodBeat.o(73525);
        return amF;
    }

    public final void remove(String str) {
        AppMethodBeat.i(73526);
        as bra = bra();
        if (bra == null) {
            AppMethodBeat.o(73526);
            return;
        }
        bra.remove(str);
        AppMethodBeat.o(73526);
    }

    public final String get(String str, String str2) {
        AppMethodBeat.i(73527);
        as bra = bra();
        if (bra == null) {
            AppMethodBeat.o(73527);
            return str2;
        }
        str2 = bra.getString(str, str2);
        AppMethodBeat.o(73527);
        return str2;
    }

    public final String[] allKeys() {
        AppMethodBeat.i(73528);
        as bra = bra();
        if (bra == null) {
            AppMethodBeat.o(73528);
            return null;
        }
        String[] allKeys = bra.allKeys();
        AppMethodBeat.o(73528);
        return allKeys;
    }
}
