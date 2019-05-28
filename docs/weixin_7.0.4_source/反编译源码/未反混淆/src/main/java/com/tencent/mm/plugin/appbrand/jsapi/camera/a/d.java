package com.tencent.mm.plugin.appbrand.jsapi.camera.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.camera.a.b.a;

public final class d extends c implements a {
    private a hHy = new a(this, "barcode|qrcode");

    public d() {
        AppMethodBeat.i(130980);
        AppMethodBeat.o(130980);
    }

    /* Access modifiers changed, original: protected|final */
    public final b aDs() {
        return this.hHy;
    }

    public final void c(int i, String str, byte[] bArr) {
        AppMethodBeat.i(130981);
        this.hHx.b(i, str, bArr);
        AppMethodBeat.o(130981);
    }
}
