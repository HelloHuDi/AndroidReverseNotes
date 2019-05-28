package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.d;

public final class j implements a {
    public final int aEN() {
        AppMethodBeat.i(131433);
        if (aER()) {
            AppMethodBeat.o(131433);
            return 5;
        }
        AppMethodBeat.o(131433);
        return 20;
    }

    public final int aEO() {
        AppMethodBeat.i(131434);
        if (aER()) {
            AppMethodBeat.o(131434);
            return 20;
        }
        AppMethodBeat.o(131434);
        return 200;
    }

    private static boolean aER() {
        AppMethodBeat.i(131436);
        if (WebView.getUsingTbsCoreVersion(ah.getContext()) >= 36867) {
            AppMethodBeat.o(131436);
            return true;
        } else if (WebView.getCurWebType() == d.WV_KIND_CW) {
            AppMethodBeat.o(131436);
            return true;
        } else {
            AppMethodBeat.o(131436);
            return false;
        }
    }

    public final boolean a(c cVar, com.tencent.mm.plugin.appbrand.jsapi.ah ahVar) {
        boolean z;
        AppMethodBeat.i(131435);
        if (!cVar.isRunning()) {
            z = false;
        } else if (cVar instanceof h) {
            h hVar = (h) cVar;
            if (hVar.getRuntime() instanceof o) {
                z = ((o) hVar.getRuntime()).xY().a(cVar, (b) ahVar);
            } else {
                ab.e("MicroMsg.SensorJsEventControllerWx", "hasPermission not AppBrandRuntimeWC");
                z = false;
            }
        } else {
            ab.e("MicroMsg.SensorJsEventControllerWx", "hasPermission AppBrandComponentWithExtra");
            z = false;
        }
        if (z) {
            AppMethodBeat.o(131435);
            return true;
        }
        AppMethodBeat.o(131435);
        return false;
    }
}
