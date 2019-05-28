package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.config.c;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.TimeUnit;

public final class x extends com.tencent.mm.ai.a<anx> {
    private static final long has = TimeUnit.MINUTES.toSeconds(5);

    public enum a {
        DAILY,
        SEARCH;

        static {
            AppMethodBeat.o(129701);
        }
    }

    public final /* synthetic */ void a(int i, int i2, String str, btd btd, m mVar) {
        AppMethodBeat.i(129704);
        anx anx = (anx) btd;
        super.a(i, i2, str, anx, mVar);
        c xH = f.xH();
        com.tencent.mm.plugin.appbrand.q.a auZ = f.auZ();
        if (xH == null || auZ == null) {
            ab.e("MicroMsg.CgiGetSearchShowOutWxaApp", "storage NULL [ %s | %s ]", xH, auZ);
            AppMethodBeat.o(129704);
            return;
        }
        long j = (i == 0 && i2 == 0 && anx != null) ? (long) anx.wsu : has;
        xH.bG("GetSearchShowOutWxaApp_interval", String.valueOf(j));
        if (i == 0 && i2 == 0 && anx != null) {
            try {
                auZ.s("GetSearchShowOutWxaApp_resp", anx.toByteArray());
                AppMethodBeat.o(129704);
                return;
            } catch (Exception e) {
                ab.e("MicroMsg.CgiGetSearchShowOutWxaApp", "save resp e %s", e);
            }
        }
        AppMethodBeat.o(129704);
    }

    public static void axL() {
        AppMethodBeat.i(129702);
        if (g.RN().eJb) {
            g.K(d.class);
            AppMethodBeat.o(129702);
            return;
        }
        AppMethodBeat.o(129702);
    }

    static anx axM() {
        AppMethodBeat.i(129703);
        anx anx = (anx) f.auZ().e("GetSearchShowOutWxaApp_resp", anx.class);
        AppMethodBeat.o(129703);
        return anx;
    }

    static {
        AppMethodBeat.i(129705);
        AppMethodBeat.o(129705);
    }
}
