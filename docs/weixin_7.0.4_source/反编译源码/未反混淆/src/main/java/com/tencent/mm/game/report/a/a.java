package com.tencent.mm.game.report.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.net.URLEncoder;

public final class a implements b {
    public final String a(com.tencent.mm.plugin.expt.a.a.a aVar, String str) {
        AppMethodBeat.i(59592);
        String a = ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(aVar, str);
        if (!a.equals(str)) {
            c.eBG.g(2, aVar.name(), kX(a));
        }
        ab.i("MicroMsg.GameExptManager", "key: %s, result: %s", aVar.name(), a);
        AppMethodBeat.o(59592);
        return a;
    }

    public final boolean a(com.tencent.mm.plugin.expt.a.a.a aVar) {
        AppMethodBeat.i(59593);
        boolean a = ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(aVar, false);
        c.eBG.g(2, aVar.name(), String.valueOf(a));
        ab.i("MicroMsg.GameExptManager", "key: %s, result: %b", aVar.name(), Boolean.valueOf(a));
        AppMethodBeat.o(59593);
        return a;
    }

    private static String kX(String str) {
        AppMethodBeat.i(59594);
        try {
            str = URLEncoder.encode(str, "UTF-8");
            AppMethodBeat.o(59594);
        } catch (Exception e) {
            AppMethodBeat.o(59594);
        }
        return str;
    }
}
