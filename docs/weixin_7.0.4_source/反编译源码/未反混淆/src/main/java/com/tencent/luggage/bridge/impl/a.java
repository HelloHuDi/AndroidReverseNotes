package com.tencent.luggage.bridge.impl;

import com.tencent.luggage.bridge.a.a.b;
import com.tencent.luggage.bridge.a.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.vfs.FileSystemManager;

public class a implements b {
    final com.tencent.mm.plugin.appbrand.d.a bOW = new com.tencent.luggage.bridge.impl.a.b();

    public a() {
        AppMethodBeat.i(90759);
        AppMethodBeat.o(90759);
    }

    public void a(c cVar) {
        AppMethodBeat.i(90760);
        FileSystemManager.setContext(ah.getContext());
        cVar.a(com.tencent.mm.plugin.appbrand.d.a.class, this.bOW);
        AppMethodBeat.o(90760);
    }

    public void a(com.tencent.luggage.bridge.a.a.a aVar) {
        AppMethodBeat.i(90761);
        aVar.a(com.tencent.mm.plugin.appbrand.d.a.class, (com.tencent.luggage.a.b) this.bOW);
        AppMethodBeat.o(90761);
    }
}
