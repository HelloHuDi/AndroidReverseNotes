package com.tencent.mm.plugin.appbrand.t.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class d extends g implements b {
    private String iSM = "*";

    public final void Eo(String str) {
        AppMethodBeat.i(73266);
        if (str == null) {
            ab.i("MicroMsg.AppBrandNetWork.HandshakeImpl1Client", "http resource descriptor must not be null");
            AppMethodBeat.o(73266);
            return;
        }
        this.iSM = str;
        AppMethodBeat.o(73266);
    }

    public final String aOu() {
        return this.iSM;
    }
}
