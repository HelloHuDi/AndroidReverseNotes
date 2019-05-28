package com.tencent.mm.plugin.appbrand.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.a.c;
import com.tencent.mm.d.a.g;
import com.tencent.mm.d.a.v;

public final class b extends c {
    public b(String str, byte[] bArr) {
        super(str, bArr);
    }

    /* Access modifiers changed, original: protected|final */
    public final c r(String str, byte[] bArr) {
        AppMethodBeat.i(113931);
        v i = g.i(str, bArr);
        AppMethodBeat.o(113931);
        return i;
    }
}
