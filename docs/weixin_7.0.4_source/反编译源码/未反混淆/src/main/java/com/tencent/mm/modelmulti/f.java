package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class f extends m implements k {
    private com.tencent.mm.ai.f ehi;
    public long fHM = -1;
    private byte[] fIi;
    private q ftU;
    private int uin = 0;

    public static class b implements q {
        private final com.tencent.mm.protocal.u.a fIj = new com.tencent.mm.protocal.u.a();
        private final com.tencent.mm.protocal.u.b fIk = new com.tencent.mm.protocal.u.b();
        int uin;

        public b() {
            AppMethodBeat.i(58371);
            AppMethodBeat.o(58371);
        }

        public final int getType() {
            return 268369922;
        }

        public final String getUri() {
            return null;
        }

        public final d acF() {
            AppMethodBeat.i(58372);
            this.fIj.vye = com.tencent.mm.compatible.e.q.LM();
            this.fIj.vyd = com.tencent.mm.protocal.d.eSg;
            this.fIj.vyc = com.tencent.mm.protocal.d.vxo;
            this.fIj.hB(this.uin);
            com.tencent.mm.protocal.u.a aVar = this.fIj;
            AppMethodBeat.o(58372);
            return aVar;
        }

        public final boolean acG() {
            return false;
        }

        public final int acC() {
            return 0;
        }

        public final int acB() {
            return 0;
        }

        public final boolean acH() {
            return true;
        }

        public final /* bridge */ /* synthetic */ e ZS() {
            return this.fIk;
        }
    }

    public static class a extends com.tencent.mm.ai.k {
        private final com.tencent.mm.protocal.u.a fIj = new com.tencent.mm.protocal.u.a();
        private final com.tencent.mm.protocal.u.b fIk = new com.tencent.mm.protocal.u.b();

        public a() {
            AppMethodBeat.i(58370);
            AppMethodBeat.o(58370);
        }

        public final int getType() {
            return 268369922;
        }

        public final String getUri() {
            return null;
        }

        public final int acB() {
            return 0;
        }

        public final /* bridge */ /* synthetic */ d ZR() {
            return this.fIj;
        }

        public final /* bridge */ /* synthetic */ e ZS() {
            return this.fIk;
        }
    }

    public f(long j, byte[] bArr) {
        this.fHM = j;
        this.fIi = bArr;
    }

    public f(long j, byte[] bArr, int i) {
        this.fHM = j;
        this.fIi = bArr;
        this.uin = i;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ai.f fVar) {
        AppMethodBeat.i(58373);
        if (bo.cb(this.fIi)) {
            ab.e("MicroMsg.NetSceneNotifyData", "dkpush %s", "get keyBuf failed");
            AppMethodBeat.o(58373);
            return -1;
        }
        if (this.uin == 0) {
            this.ftU = new a();
        } else {
            this.ftU = new b();
            ((b) this.ftU).uin = this.uin;
        }
        ab.i("MicroMsg.NetSceneNotifyData", "doScene now:%d buf:%s", Long.valueOf(this.fHM), bo.bZ(this.fIi));
        ((com.tencent.mm.protocal.u.a) this.ftU.acF()).fJB = this.fHM;
        ((com.tencent.mm.protocal.u.a) this.ftU.acF()).cAG = this.fIi;
        this.ehi = fVar;
        int a = a(eVar, this.ftU, this);
        AppMethodBeat.o(58373);
        return a;
    }

    public final int getType() {
        return 268369922;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(58374);
        ab.i("MicroMsg.NetSceneNotifyData", "onGYNetEnd [%d,%d] %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(58374);
    }
}
