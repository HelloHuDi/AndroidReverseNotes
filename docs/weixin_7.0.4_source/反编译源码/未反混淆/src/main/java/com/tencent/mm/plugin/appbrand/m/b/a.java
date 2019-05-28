package com.tencent.mm.plugin.appbrand.m.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.sdk.platformtools.ab;

public class a {
    public d iqc;

    public final String aIW() {
        AppMethodBeat.i(102189);
        ab.i("MicroMsg.AppBrandNodeJSInstallHelper", "getNodeInjectJs");
        if (this.iqc == null) {
            IllegalStateException illegalStateException = new IllegalStateException("You had not called whenCreateJsRuntime!");
            AppMethodBeat.o(102189);
            throw illegalStateException;
        }
        String Eb = com.tencent.mm.plugin.appbrand.r.d.Eb("wxa_library/node_jsapi.js");
        AppMethodBeat.o(102189);
        return Eb;
    }
}
