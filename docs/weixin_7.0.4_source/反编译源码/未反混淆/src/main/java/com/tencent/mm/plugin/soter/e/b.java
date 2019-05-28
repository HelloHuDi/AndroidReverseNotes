package com.tencent.mm.plugin.soter.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.soter.d.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.f;
import com.tencent.mm.vending.j.c;

public final class b {
    public static void a(boolean z, boolean z2, final g gVar) {
        AppMethodBeat.i(59357);
        ab.i("MicroMsg.SoterInitManager", "alvinluo isNeedPrepareAsk: %b, isNeedSaveDeviceInfo: %b", Boolean.valueOf(z), Boolean.valueOf(z2));
        try {
            final long currentTimeMillis = System.currentTimeMillis();
            f.D(Boolean.valueOf(z), Boolean.valueOf(z2)).d(new a()).d(new c()).d(new d()).a((a) new a<c<Integer, String>>() {
                public final /* synthetic */ void bi(Object obj) {
                    AppMethodBeat.i(59356);
                    c cVar = (c) obj;
                    String str = (String) cVar.get(1);
                    ab.e("MicroMsg.SoterInitManager", "alvinluo onInterrupt errCode: %d, errMsg: %s", Integer.valueOf(((Integer) cVar.get(0)).intValue()), str);
                    if (gVar != null) {
                        gVar.aC(r1, str);
                    }
                    AppMethodBeat.o(59356);
                }
            }).a(new com.tencent.mm.vending.g.d.b<Boolean>() {
                public final /* synthetic */ void az(Object obj) {
                    AppMethodBeat.i(59355);
                    ab.i("MicroMsg.SoterInitManager", "alvinluo onTerminate");
                    ab.i("MicroMsg.SoterInitManager", "alvinluo init takes %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    if (gVar != null) {
                        gVar.aC(0, "");
                    }
                    AppMethodBeat.o(59355);
                }
            });
            AppMethodBeat.o(59357);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SoterInitManager", e, "alvinluo exception when init soter: %s", e.getMessage());
            com.tencent.mm.plugin.soter.d.a.fH(4, 1001);
            if (gVar != null) {
                gVar.aC(-1, "system error");
            }
            AppMethodBeat.o(59357);
        }
    }
}
