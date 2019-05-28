package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aaa;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.protocal.protobuf.zz;
import com.tencent.mm.sdk.platformtools.ab;

public final class e extends m implements k {
    private f ehi;
    private b gme;
    public String lvz;
    public String nSX;
    private zz nUp;
    private aaa nUq;
    public String nUr;
    public String nUs;
    public int nUt;

    public e() {
        AppMethodBeat.i(42157);
        a aVar = new a();
        aVar.fsJ = new zz();
        aVar.fsK = new aaa();
        aVar.uri = "/cgi-bin/mmpay-bin/ftfhb/ffquerydowxhb";
        this.gme = aVar.acD();
        this.nUp = (zz) this.gme.fsG.fsP;
        this.nUp.timestamp = System.currentTimeMillis() / 1000;
        aw cPy = com.tencent.mm.plugin.wallet_core.model.k.cPy();
        if (cPy != null) {
            this.nUp.latitude = cPy.latitude;
            this.nUp.longitude = cPy.longitude;
        }
        AppMethodBeat.o(42157);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(42158);
        ab.i("NetSceneF2FLuckyMoneyQuery", "errType %d,errCode %d,errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.nUq = (aaa) ((b) qVar).fsH.fsP;
        this.nSX = this.nUq.nSX;
        this.lvz = this.nUq.lvz;
        this.nUt = this.nUq.wfi;
        this.nUr = this.nUq.nUr;
        this.nUs = this.nUq.nUs;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, this.nUq.kCl, this.nUq.kCm, this);
        }
        AppMethodBeat.o(42158);
    }

    public final int getType() {
        return 1990;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(42159);
        this.ehi = fVar;
        int a = a(eVar, this.gme, this);
        AppMethodBeat.o(42159);
        return a;
    }
}
