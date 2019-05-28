package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.b;
import com.tencent.mm.g.a.dk;
import com.tencent.mm.g.a.hi;
import com.tencent.mm.g.a.lk;
import com.tencent.mm.g.a.su;
import com.tencent.mm.model.av;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.modelmulti.n;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.j.f;
import com.tencent.mm.protocal.j.g;
import com.tencent.mm.protocal.protobuf.ar;
import com.tencent.mm.protocal.v;
import com.tencent.mm.sdk.platformtools.ab;

public final class a implements com.tencent.mm.plugin.auth.a.a {
    public final void a(f fVar, g gVar, boolean z) {
        AppMethodBeat.i(18229);
        if ((gVar.vxV.xic & 2) != 0) {
            ar arVar = gVar.vxV.xie;
            if (!z) {
                aw.ZK();
                c.iy(arVar.vCi);
            }
            av.fly.ou(b.pX(r.Yz()));
            if (arVar.vCf != 0) {
                aw.ZK();
                c.XU().cE(arVar.vCf + "@qqim", 3);
            }
            b.d((long) arVar.vCf, 3);
        } else {
            ab.w("MicroMsg.BigBallAuthHandle", "summerauth updateProfile acctsect not set!");
        }
        o.mg(1);
        if (z) {
            hi hiVar = new hi();
            hiVar.cCe.cCf = false;
            com.tencent.mm.sdk.b.a.xxA.m(hiVar);
            su suVar = new su();
            suVar.cOT.cOU = true;
            com.tencent.mm.sdk.b.a.xxA.m(suVar);
            AppMethodBeat.o(18229);
            return;
        }
        aw.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(18227);
                bh.oG("ver" + d.vxo);
                am.bYL().addAll(com.tencent.mm.plugin.s.a.bYJ().dhD());
                com.tencent.mm.sdk.b.a aVar = com.tencent.mm.sdk.b.a.xxA;
                if (aVar == null) {
                    ab.e("MicroMsg.BigBallAuthHandle", "EventPool is null.");
                    AppMethodBeat.o(18227);
                    return;
                }
                hi hiVar = new hi();
                hiVar.cCe.cCf = true;
                aVar.m(hiVar);
                su suVar = new su();
                suVar.cOT.cOU = true;
                aVar.m(suVar);
                aVar.m(new dk());
                aVar.m(new lk());
                com.tencent.mm.modelsimple.c.cQ(true);
                n.ahW().lN(3);
                ab.i("MicroMsg.BigBallAuthHandle", "summerbadcr triggerSync bgfg after manual auth");
                AppMethodBeat.o(18227);
            }

            public final String toString() {
                AppMethodBeat.i(18228);
                String str = super.toString() + "|onGYNetEnd2";
                AppMethodBeat.o(18228);
                return str;
            }
        });
        AppMethodBeat.o(18229);
    }

    public final void a(v.b bVar, String str, int i, String str2, String str3, int i2) {
        AppMethodBeat.i(18230);
        av.fly.ou(b.pX(r.Yz()));
        b.d((long) i, 3);
        aw.ZK();
        c.XU().cE(bVar.vyJ.wIh, 2);
        if (i != 0) {
            aw.ZK();
            c.XU().cE(i + "@qqim", 3);
        }
        AppMethodBeat.o(18230);
    }
}
