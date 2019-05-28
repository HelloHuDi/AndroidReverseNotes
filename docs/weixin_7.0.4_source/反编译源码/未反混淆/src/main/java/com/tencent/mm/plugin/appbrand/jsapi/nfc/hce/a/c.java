package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.n.b;
import com.tencent.mm.sdk.platformtools.ab;

public final class c {
    public static void G(String str, int i, int i2) {
        AppMethodBeat.i(137935);
        ab.i("MicroMsg.HCEReportManager", "alvinluo reportStartHCEResult appId: %s, result: %d, diff: %d", str, Integer.valueOf(i), Integer.valueOf(i2));
        ((b) e.C(b.class)).e(14837, str, Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(137935);
    }
}
