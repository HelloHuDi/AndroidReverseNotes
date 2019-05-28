package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public final class c extends a {
    public static final c gSg = new c();
    final WxaPkgWrappingInfo gSf;

    public final void init() {
    }

    public final InputStream openRead(String str) {
        AppMethodBeat.i(114302);
        InputStream openRead = an.openRead(str);
        AppMethodBeat.o(114302);
        return openRead;
    }

    public final WxaPkgWrappingInfo avm() {
        return this.gSf;
    }

    public c() {
        AppMethodBeat.i(114303);
        this.gSf = new WxaPkgWrappingInfo();
        this.gSf.gVw = true;
        this.gSf.gVt = 0;
        this.gSf.gVu = an.VERSION;
        this.gSf.cvZ = "";
        AppMethodBeat.o(114303);
    }

    static {
        AppMethodBeat.i(114304);
        AppMethodBeat.o(114304);
    }

    public final String toString() {
        return "AssetReader";
    }
}
