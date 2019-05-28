package com.tencent.mm.plugin.appbrand.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bc.a;

public final class d {
    public c hvw;
    public a iRh = new a() {
        public final void aNW() {
            AppMethodBeat.i(87407);
            ab.i("MicroMsg.AppBrandUserCaptureScreenMonitor", "onScreenShot callback");
            s.k(d.this.hvw);
            AppMethodBeat.o(87407);
        }
    };

    public d() {
        AppMethodBeat.i(87408);
        AppMethodBeat.o(87408);
    }
}
