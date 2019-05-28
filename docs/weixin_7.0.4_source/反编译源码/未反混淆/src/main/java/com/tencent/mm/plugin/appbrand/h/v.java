package com.tencent.mm.plugin.appbrand.h;

import com.eclipsesource.v8.V8Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.d.a.c;
import com.tencent.mm.d.a.g;
import com.tencent.mm.d.a.i;
import com.tencent.mm.d.a.l;
import com.tencent.mm.d.a.l.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class v extends a {
    public v() {
        super(null, null);
    }

    public v(String str, byte[] bArr) {
        super(str, bArr);
    }

    /* Access modifiers changed, original: protected|final */
    public final c r(String str, byte[] bArr) {
        AppMethodBeat.i(113944);
        i g = g.g(str, bArr);
        AppMethodBeat.o(113944);
        return g;
    }

    /* Access modifiers changed, original: protected|final */
    public final l a(c cVar, int i) {
        AppMethodBeat.i(113945);
        i iVar = (i) cVar;
        if (iVar.chD == null) {
            iVar.chD = new l(iVar, iVar.Cr(), new a() {
                public final V8Context Cu() {
                    AppMethodBeat.i(113816);
                    if (i.this.chC == null) {
                        IllegalStateException illegalStateException = new IllegalStateException("getMainContext mNodeJS not ready!");
                        AppMethodBeat.o(113816);
                        throw illegalStateException;
                    }
                    ab.i("MicroMsg.NodeJSRuntime", "getMainContext %s", Integer.valueOf(i.this.chC.getMainContext().hashCode()));
                    V8Context mainContext = i.this.chC.getMainContext();
                    AppMethodBeat.o(113816);
                    return mainContext;
                }
            });
        }
        l lVar = iVar.chD;
        AppMethodBeat.o(113945);
        return lVar;
    }
}
