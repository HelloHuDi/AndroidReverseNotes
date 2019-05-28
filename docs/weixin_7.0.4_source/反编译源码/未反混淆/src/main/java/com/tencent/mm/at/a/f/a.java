package com.tencent.mm.at.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.b;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.sdk.platformtools.d;

public final class a implements Runnable {
    private final b fGK = this.fHp.fGK;
    private final c fGS;
    private final com.tencent.mm.at.a.c.a fGU;
    private final com.tencent.mm.at.a.c.b fGV;
    private final com.tencent.mm.at.a.b fHp;
    private final com.tencent.mm.at.a.c.c fHq;
    private final String url;

    public a(String str, c cVar, com.tencent.mm.at.a.b bVar, com.tencent.mm.at.a.c.c cVar2) {
        AppMethodBeat.i(116104);
        this.url = str;
        this.fHp = bVar;
        if (cVar == null) {
            this.fGS = this.fGK.fGS;
        } else {
            this.fGS = cVar;
        }
        this.fHq = cVar2;
        if (this.fGS.fGV != null) {
            this.fGV = this.fGS.fGV;
        } else {
            this.fGV = this.fGK.fGV;
        }
        this.fGU = this.fGK.fGU;
        AppMethodBeat.o(116104);
    }

    public final void run() {
        AppMethodBeat.i(116105);
        com.tencent.mm.at.a.d.b bVar = new com.tencent.mm.at.a.d.b();
        bVar = this.fGV.sE(this.url);
        if (bVar == null) {
            if (this.fHq != null) {
                this.fHq.a(false, this.fGS.eQd);
                AppMethodBeat.o(116105);
                return;
            }
        } else if (!(d.decodeByteArray(bVar.data, 10, 10) == null && this.fGS.eQb) && this.fGU.a(this.url, bVar.data, this.fGS)) {
            if (this.fHq != null) {
                this.fHq.a(true, this.fGS.eQd);
                AppMethodBeat.o(116105);
                return;
            }
        } else if (this.fHq != null) {
            this.fHq.a(false, this.fGS.eQd);
        }
        AppMethodBeat.o(116105);
    }
}
