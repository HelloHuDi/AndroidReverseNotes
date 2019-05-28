package com.tencent.mm.plugin.appbrand.jsapi.p;

import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.s.t.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class h {
    private static String hVR = "";
    private static String hVS = "";
    private static g hVT = new g();
    private static a hVU = a.NONE;
    private static a hVV = a.NONE;
    private static boolean mEnable = false;

    static {
        AppMethodBeat.i(126390);
        AppMethodBeat.o(126390);
    }

    public static void s(c cVar) {
        AppMethodBeat.i(126386);
        hVR = cVar.getAppId();
        mEnable = true;
        hVT.j(cVar);
        if (hVV == a.NONE || !hVS.equalsIgnoreCase(hVR)) {
            hVV = a.NONE;
        } else {
            hVT.a(hVV);
        }
        ab.i("MicroMsg.OrientationConfigListenerHelper", "init mJsAppid:" + hVR + "; mEnable:" + mEnable);
        AppMethodBeat.o(126386);
    }

    public static void t(c cVar) {
        AppMethodBeat.i(126387);
        if (cVar.getAppId().equalsIgnoreCase(hVR)) {
            ab.i("MicroMsg.OrientationConfigListenerHelper", "unInit mAppid:" + hVR);
            hVR = "";
            mEnable = false;
            hVV = a.NONE;
        }
        AppMethodBeat.o(126387);
    }

    public static void a(Configuration configuration, String str) {
        AppMethodBeat.i(126388);
        if (configuration.orientation == 2) {
            if (hVU == a.REVERSE_LANDSCAPE) {
                hVV = a.REVERSE_LANDSCAPE;
            } else {
                hVV = a.LANDSCAPE;
            }
        } else if (configuration.orientation == 1) {
            hVV = a.PORTRAIT;
        } else {
            hVV = a.NONE;
        }
        ab.i("MicroMsg.OrientationConfigListenerHelper", "onConfigurationChanged mAppid:" + hVR + "; appid:" + str + "; mOrientation:" + hVV.name());
        if (!hVR.equalsIgnoreCase("") && hVR.equalsIgnoreCase(str) && mEnable) {
            hVT.a(hVV);
            AppMethodBeat.o(126388);
            return;
        }
        hVS = str;
        AppMethodBeat.o(126388);
    }

    public static void b(a aVar) {
        AppMethodBeat.i(126389);
        hVU = aVar;
        if (mEnable && hVV == a.LANDSCAPE && (aVar == a.REVERSE_LANDSCAPE || aVar == a.LANDSCAPE)) {
            hVT.a(aVar);
            ab.i("MicroMsg.OrientationConfigListenerHelper", "onFourOrientationsChange mAppid:" + hVR + "; mOrientation:" + aVar.name());
        }
        AppMethodBeat.o(126389);
    }
}
