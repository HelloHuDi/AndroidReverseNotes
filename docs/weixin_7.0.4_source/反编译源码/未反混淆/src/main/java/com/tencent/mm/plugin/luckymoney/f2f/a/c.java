package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.protocal.protobuf.bpt;
import com.tencent.mm.protocal.protobuf.zx;
import com.tencent.mm.protocal.protobuf.zy;
import com.tencent.mm.sdk.platformtools.ab;

public final class c extends m implements k {
    public int cRU;
    public int cvG;
    private f ehi;
    private b gme;
    public String nSX;
    private zx nUb;
    private zy nUc;
    public int nUd;
    public String nUe;
    public int nUf;
    public bpt nUg;
    public int nUh;
    public String nUi;
    public String nUj;
    public String nUk;
    public int nUl;

    public c(String str) {
        AppMethodBeat.i(42151);
        a aVar = new a();
        aVar.fsJ = new zx();
        aVar.fsK = new zy();
        aVar.uri = "/cgi-bin/mmpay-bin/ftfhb/ffopenwxhb";
        this.gme = aVar.acD();
        this.nUb = (zx) this.gme.fsG.fsP;
        this.nUb.lvz = str;
        aw cPy = com.tencent.mm.plugin.wallet_core.model.k.cPy();
        if (cPy != null) {
            this.nUb.dud = cPy.dud;
            this.nUb.duc = cPy.duc;
            this.nUb.wfd = cPy.vCF;
            this.nUb.wfe = cPy.vCG;
            this.nUb.wff = cPy.vCE;
            this.nUb.wfg = cPy.latitude;
            this.nUb.wfh = cPy.longitude;
        }
        AppMethodBeat.o(42151);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(42152);
        this.nUc = (zy) ((b) qVar).fsH.fsP;
        ab.i("NetSceneF2FLuckyMoneyOpen", "errType %d, retCode %d, retMsg %s", Integer.valueOf(i2), Integer.valueOf(this.nUc.kCl), this.nUc.kCm);
        this.nSX = this.nUc.nSX;
        this.cRU = this.nUc.cRU;
        this.nUd = this.nUc.cRV;
        this.cvG = this.nUc.cvG;
        this.nUe = this.nUc.nXl;
        this.nUf = this.nUc.nUf;
        this.nUg = this.nUc.vWf;
        this.nUh = this.nUc.nUh;
        this.nUi = this.nUc.nUi;
        this.nUj = this.nUc.nUj;
        this.nUk = this.nUc.nUk;
        this.nUl = this.nUc.nUl;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, this.nUc.kCl, this.nUc.kCm, this);
        }
        AppMethodBeat.o(42152);
    }

    public final int getType() {
        return 1997;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(42153);
        this.ehi = fVar;
        int a = a(eVar, this.gme, this);
        AppMethodBeat.o(42153);
        return a;
    }
}
