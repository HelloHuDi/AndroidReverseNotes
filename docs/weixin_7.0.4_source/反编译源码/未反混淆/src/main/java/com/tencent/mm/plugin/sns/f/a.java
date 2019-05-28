package com.tencent.mm.plugin.sns.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rj;
import com.tencent.mm.plugin.sns.data.e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.az;

public final class a implements b {
    public c qGl = new c<rj>() {
        {
            AppMethodBeat.i(35873);
            this.xxI = rj.class.getName().hashCode();
            AppMethodBeat.o(35873);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(35874);
            rj rjVar = (rj) bVar;
            if (rjVar instanceof rj) {
                if (rjVar.cNq.cuy == 1) {
                    ab.i("MicroMsg.FTS.FTSSnsImageDownloadLogic", "start do download id %s", rjVar.cNq.cNr.Id);
                    e eVar = new e(rjVar.cNq.cNr);
                    eVar.qFQ = 1;
                    eVar.nQB = rjVar.cNq.cNr.Id;
                    if (rjVar.cNq.cNr.jCt == 6) {
                        af.cnA().a(rjVar.cNq.cNr, 5, eVar, az.xYW);
                    } else {
                        af.cnA().a(rjVar.cNq.cNr, 1, eVar, az.xYW);
                    }
                } else if (rjVar.cNq.cuy == 3) {
                    String fZ = an.fZ(af.getAccSnsPath(), rjVar.cNq.cHr);
                    String Xa = i.Xa(rjVar.cNq.cHr);
                    rjVar.cNq.path = fZ + Xa;
                }
            }
            AppMethodBeat.o(35874);
            return false;
        }
    };

    public a() {
        AppMethodBeat.i(35875);
        com.tencent.mm.sdk.b.a.xxA.c(this.qGl);
        af.cnA().a((b) this);
        AppMethodBeat.o(35875);
    }

    public final void Xw(String str) {
        AppMethodBeat.i(35876);
        ab.i("MicroMsg.FTS.FTSSnsImageDownloadLogic", "onThumbFinish mediaId=%s", str);
        rj rjVar = new rj();
        rjVar.cNq.cuy = 2;
        rjVar.cNq.cHr = str;
        String fZ = an.fZ(af.getAccSnsPath(), str);
        rjVar.cNq.path = fZ + i.Xa(str);
        com.tencent.mm.sdk.b.a.xxA.m(rjVar);
        AppMethodBeat.o(35876);
    }

    public final void bj(String str, boolean z) {
    }

    public final void cmu() {
    }

    public final void bk(String str, boolean z) {
    }
}
