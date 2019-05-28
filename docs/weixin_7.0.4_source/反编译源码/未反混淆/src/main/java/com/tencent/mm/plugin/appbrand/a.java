package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.d;
import com.tencent.mm.plugin.appbrand.ui.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class a {
    private static final Map<String, o> gMD = new HashMap();
    private static Map<String, android.support.v4.app.a.a> gME = new HashMap();
    private static Map<String, k> gMF = new HashMap();

    static {
        AppMethodBeat.i(128924);
        AppMethodBeat.o(128924);
    }

    public static void asC() {
        AppMethodBeat.i(128918);
        LinkedList<o> linkedList = new LinkedList();
        synchronized (gMD) {
            try {
                for (o oVar : gMD.values()) {
                    if (oVar != null && oVar.xy()) {
                        linkedList.add(oVar);
                    }
                }
            } finally {
                AppMethodBeat.o(128918);
            }
        }
        for (o oVar2 : linkedList) {
            oVar2.atP();
        }
    }

    public static o wI(String str) {
        AppMethodBeat.i(128921);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(128921);
            return null;
        }
        o oVar;
        synchronized (gMD) {
            try {
                oVar = (o) gMD.get(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(128921);
            }
        }
        return oVar;
    }

    @Deprecated
    public static AppBrandSysConfigWC wJ(String str) {
        AppMethodBeat.i(128922);
        o wI = wI(str);
        if (wI == null) {
            AppMethodBeat.o(128922);
            return null;
        }
        AppBrandSysConfigWC atH = wI.atH();
        AppMethodBeat.o(128922);
        return atH;
    }

    @Deprecated
    public static AppBrandStatObject wK(String str) {
        AppMethodBeat.i(128923);
        o wI = wI(str);
        if (wI == null) {
            AppMethodBeat.o(128923);
            return null;
        }
        AppBrandStatObject appBrandStatObject = wI.ya().bQn;
        AppMethodBeat.o(128923);
        return appBrandStatObject;
    }

    static void a(o oVar) {
        AppMethodBeat.i(128919);
        if (bo.isNullOrNil(oVar.mAppId)) {
            ab.e("MicroMsg.AppBrandBridge", "clearRuntime with nil appId");
            AppMethodBeat.o(128919);
            return;
        }
        synchronized (gMD) {
            try {
                o oVar2 = (o) gMD.get(oVar.mAppId);
                if (oVar2 == null || oVar2 == oVar) {
                    gMD.put(oVar.mAppId, null);
                } else {
                    ab.e("MicroMsg.AppBrandBridge", "clearRuntime with mismatch instance, stack %s", bo.l(new Throwable()));
                }
            } finally {
                AppMethodBeat.o(128919);
            }
        }
    }

    static void b(o oVar) {
        AppMethodBeat.i(128920);
        if (bo.isNullOrNil(oVar.mAppId)) {
            ab.e("MicroMsg.AppBrandBridge", "setRuntime with nil appId");
            AppMethodBeat.o(128920);
            return;
        }
        synchronized (gMD) {
            try {
                gMD.put(oVar.mAppId, oVar);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(128920);
                }
            }
        }
        if (oVar.atI() != null) {
            d.bs(oVar.mAppId, oVar.atI().bQe);
        }
        AppMethodBeat.o(128920);
    }
}
