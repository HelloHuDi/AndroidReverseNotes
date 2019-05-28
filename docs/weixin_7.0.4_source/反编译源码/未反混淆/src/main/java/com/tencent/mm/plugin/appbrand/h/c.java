package com.tencent.mm.plugin.appbrand.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.a.g;
import com.tencent.mm.d.a.l;
import com.tencent.mm.d.a.v;

public class c extends a {
    public c() {
        this(null, null);
    }

    public c(String str, byte[] bArr) {
        super(str, bArr);
    }

    /* Access modifiers changed, original: protected */
    public com.tencent.mm.d.a.c r(String str, byte[] bArr) {
        AppMethodBeat.i(113932);
        v h = g.h(str, bArr);
        AppMethodBeat.o(113932);
        return h;
    }

    /* Access modifiers changed, original: protected|final */
    public final l a(com.tencent.mm.d.a.c cVar, int i) {
        AppMethodBeat.i(113933);
        l gm = cVar.gm(i);
        AppMethodBeat.o(113933);
        return gm;
    }
}
