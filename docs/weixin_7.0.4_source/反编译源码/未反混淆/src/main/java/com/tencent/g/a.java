package com.tencent.g;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a implements com.tencent.g.b.a {
    private g AHy;
    private boolean alP = true;

    protected a(g gVar) {
        this.AHy = gVar;
    }

    public final void t(String str, Object obj) {
        AppMethodBeat.i(127741);
        if (this.alP) {
            f dSG = f.dSG();
            if (obj == null) {
                h hVar = new h("TpfServiceCenter|registerService|name or service should not be null");
                AppMethodBeat.o(127741);
                throw hVar;
            }
            synchronized (dSG.AHE) {
                try {
                    dSG.AHC.put(str, obj);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(127741);
                }
            }
            return;
        }
        AppMethodBeat.o(127741);
    }
}
