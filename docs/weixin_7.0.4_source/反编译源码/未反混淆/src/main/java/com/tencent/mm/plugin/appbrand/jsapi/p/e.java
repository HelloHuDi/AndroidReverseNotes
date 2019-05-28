package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import com.tencent.mm.plugin.appbrand.s.t;
import com.tencent.mm.plugin.appbrand.s.t.a;
import com.tencent.mm.plugin.appbrand.s.t.b;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class e extends u {
    public static final int CTRL_INDEX = 472;
    public static final String NAME = "enableDeviceOrientationChangeListening";
    private boolean hVI = false;
    protected t hVJ;
    private b hVK = new b() {
        public final void a(a aVar, final a aVar2) {
            AppMethodBeat.i(126379);
            ab.i("MicroMsg.JsApiEnableDeviceOrientation", "OrientationListener lastOrientation:" + aVar.name() + "; newOrientation:" + aVar2.name());
            com.tencent.mm.ce.a.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(126378);
                    h.b(aVar2);
                    AppMethodBeat.o(126378);
                }
            }, 500);
            AppMethodBeat.o(126379);
        }
    };

    public e() {
        AppMethodBeat.i(126380);
        AppMethodBeat.o(126380);
    }

    public final String b(c cVar, JSONObject jSONObject) {
        AppMethodBeat.i(126381);
        if (jSONObject.optBoolean("enable", false)) {
            h.s(cVar);
            if (!this.hVI) {
                this.hVJ = new t(cVar.getContext(), this.hVK);
                this.hVJ.enable();
                this.hVI = true;
            }
        } else {
            h.t(cVar);
            if (this.hVI) {
                this.hVJ.disable();
                this.hVJ = null;
                this.hVI = false;
            }
        }
        String j = j("ok", null);
        AppMethodBeat.o(126381);
        return j;
    }
}
