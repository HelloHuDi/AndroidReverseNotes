package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.account.friend.a.r.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.bzr;
import com.tencent.mm.protocal.protobuf.cfi;
import com.tencent.mm.protocal.protobuf.xv;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;

public final class z extends m implements k {
    private f ehi;
    public q ftU;
    private int ftx;

    public static class a extends com.tencent.mm.ai.k {
        private com.tencent.mm.plugin.account.friend.a.r.a gvZ = new com.tencent.mm.plugin.account.friend.a.r.a();
        private b gwa = new b();

        public a() {
            AppMethodBeat.i(108436);
            AppMethodBeat.o(108436);
        }

        public final int getType() {
            return com.tencent.mm.plugin.appbrand.jsapi.audio.m.CTRL_INDEX;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/emailreg";
        }

        public final e ZS() {
            return this.gwa;
        }

        public final d ZR() {
            return this.gvZ;
        }

        public final int acC() {
            return 1;
        }
    }

    private z(int i, String str, String str2, String str3) {
        AppMethodBeat.i(108437);
        this.ftx = 2;
        this.ftU = new a();
        com.tencent.mm.plugin.account.friend.a.r.a aVar = (com.tencent.mm.plugin.account.friend.a.r.a) this.ftU.acF();
        aVar.gvF.vIJ = i;
        aVar.gvF.vLe = str;
        aVar.gvF.luQ = aa.dor();
        aVar.gvF.vLJ = bo.and(str2);
        aVar.gvF.wdy = str3;
        xv xvVar = aVar.gvF;
        g.RN();
        xvVar.vIj = com.tencent.mm.kernel.a.Rb();
        aVar.gvF.wdz = com.tencent.mm.compatible.e.q.getSimCountryIso();
        aVar.gvF.wdA = 1;
        AppMethodBeat.o(108437);
    }

    public z(String str, String str2, String str3) {
        this(2, str, str2, str3);
    }

    public z(String str, String str2) {
        this(1, str, str2, "");
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(108438);
        this.ehi = fVar;
        int a = a(eVar, this.ftU, this);
        AppMethodBeat.o(108438);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(108439);
        ab.i("MicroMsg.NetSceneEmailReg", "onGYNetEnd  errType:%d errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        b bVar = (b) qVar.ZS();
        if (i2 == 4 && i3 == -301) {
            ax.a(true, bVar.gvG.vLL, bVar.gvG.vLM, bVar.gvG.vLK);
            this.ftx--;
            if (this.ftx <= 0) {
                this.ehi.onSceneEnd(3, -1, "", this);
                AppMethodBeat.o(108439);
                return;
            }
            a(this.ftf, this.ehi);
            AppMethodBeat.o(108439);
        } else if (i2 == 0 && i3 == 0) {
            ax.a(false, bVar.gvG.vLL, bVar.gvG.vLM, bVar.gvG.vLK);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(108439);
        } else {
            ab.e("MicroMsg.NetSceneEmailReg", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(108439);
        }
    }

    public final int acn() {
        return 5;
    }

    public final m.b b(q qVar) {
        return m.b.EOk;
    }

    public final int ajx() {
        int i;
        AppMethodBeat.i(108440);
        bzr bzr = ((b) this.ftU.ZS()).gvG.vHR;
        if (!(bzr == null || bzr.wYM == null || bzr.wYM.size() <= 0)) {
            Iterator it = bzr.wYM.iterator();
            while (it.hasNext()) {
                cfi cfi = (cfi) it.next();
                if (cfi.pXC == 1) {
                    i = bo.getInt(cfi.xeN, 0);
                    break;
                }
            }
        }
        i = 0;
        AppMethodBeat.o(108440);
        return i;
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.audio.m.CTRL_INDEX;
    }
}
