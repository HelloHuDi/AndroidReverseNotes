package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public final class a {
    boolean hGi;
    boolean hGj;
    HashMap<Integer, e> hGk;

    static class a {
        private static a hGl = new a();

        static {
            AppMethodBeat.i(126238);
            AppMethodBeat.o(126238);
        }
    }

    /* synthetic */ a(byte b) {
        this();
    }

    private a() {
        AppMethodBeat.i(126239);
        this.hGi = true;
        this.hGj = true;
        this.hGk = new HashMap();
        AppMethodBeat.o(126239);
    }

    public final boolean aDa() {
        AppMethodBeat.i(126240);
        if (!this.hGi) {
            ab.i("MicroMsg.AppBrandCameraMrg", "no camera permission");
        }
        boolean z = this.hGi;
        AppMethodBeat.o(126240);
        return z;
    }
}
