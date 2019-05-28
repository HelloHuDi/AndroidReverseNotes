package com.tencent.mm.plugin.wepkg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.e;
import com.tencent.mm.plugin.wepkg.model.f;
import com.tencent.mm.plugin.wepkg.model.g;
import com.tencent.mm.plugin.wepkg.model.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.xweb.o;

public final class a {
    private static f uVn;
    private static boolean uVo = false;

    public static String dga() {
        AppMethodBeat.i(63339);
        String bDi = com.tencent.mm.plugin.game.commlib.a.bDi();
        if (bo.isNullOrNil(bDi)) {
            bDi = "commlib";
            AppMethodBeat.o(63339);
            return bDi;
        }
        AppMethodBeat.o(63339);
        return bDi;
    }

    public static void biO() {
        AppMethodBeat.i(63340);
        sg();
        AppMethodBeat.o(63340);
    }

    public static void aht(String str) {
        AppMethodBeat.i(63341);
        if (dga().equals(str)) {
            uVo = true;
        }
        AppMethodBeat.o(63341);
    }

    public static void bM(String str, boolean z) {
        AppMethodBeat.i(63342);
        if (dga().equals(str) && (uVo || b.dgf() == 0)) {
            uVo = false;
            if (z) {
                sg();
            }
        }
        AppMethodBeat.o(63342);
    }

    public static void sg() {
        AppMethodBeat.i(63343);
        ab.i("MicroMsg.CommJsLoader", "load");
        h.a(dga(), new com.tencent.mm.plugin.wepkg.model.a() {
            public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
                AppMethodBeat.i(63338);
                WepkgVersion wepkgVersion = ((WepkgCrossProcessTask) baseWepkgProcessTask).uWY;
                if (wepkgVersion == null) {
                    ab.e("MicroMsg.CommJsLoader", "wepkgVersion is null");
                    a.uVn = null;
                    AppMethodBeat.o(63338);
                } else if (wepkgVersion.version == null) {
                    ab.e("MicroMsg.CommJsLoader", "version is null");
                    a.uVn = null;
                    AppMethodBeat.o(63338);
                } else if (a.uVn != null && wepkgVersion.version.equals(a.uVn.uWY.version)) {
                    AppMethodBeat.o(63338);
                } else if (wepkgVersion.uXM) {
                    e a = g.a(a.dga(), wepkgVersion.version, wepkgVersion.gSP, wepkgVersion.cvZ, wepkgVersion.uXK);
                    if (a == null || bo.isNullOrNil(wepkgVersion.gSP) || !com.tencent.mm.a.e.ct(wepkgVersion.gSP)) {
                        ab.e("MicroMsg.CommJsLoader", "path not exist");
                        AppMethodBeat.o(63338);
                        return;
                    }
                    a.uVn = new f(wepkgVersion, a, null);
                    AppMethodBeat.o(63338);
                } else {
                    ab.e("MicroMsg.CommJsLoader", "bigPackage is not ready");
                    AppMethodBeat.o(63338);
                }
            }
        });
        AppMethodBeat.o(63343);
    }

    public static o ahu(String str) {
        AppMethodBeat.i(63344);
        if (!b.enable() || uVn == null) {
            ab.e("MicroMsg.CommJsLoader", "nativeJsCache is null");
            AppMethodBeat.o(63344);
            return null;
        }
        o ahS = uVn.ahS(str);
        if (ahS != null) {
            AppMethodBeat.o(63344);
            return ahS;
        }
        AppMethodBeat.o(63344);
        return null;
    }

    public static String dgb() {
        if (uVn == null || uVn.uWY == null) {
            return "";
        }
        return uVn.uWY.version;
    }
}
