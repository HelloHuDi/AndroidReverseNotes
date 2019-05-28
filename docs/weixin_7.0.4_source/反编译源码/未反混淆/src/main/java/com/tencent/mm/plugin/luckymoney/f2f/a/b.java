package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.protocal.protobuf.zv;
import com.tencent.mm.protocal.protobuf.zw;
import com.tencent.mm.sdk.platformtools.ab;

public final class b extends m implements k {
    private f ehi;
    private com.tencent.mm.ai.b gme;
    public int kCl;
    public String kCm;
    private zv nTZ;
    private zw nUa;

    public b(String str) {
        AppMethodBeat.i(42148);
        a aVar = new a();
        aVar.fsJ = new zv();
        aVar.fsK = new zw();
        aVar.fsI = 1971;
        aVar.uri = "/cgi-bin/mmpay-bin/ftfhb/ffwxhbinvalidateshareurl";
        this.gme = aVar.acD();
        this.nTZ = (zv) this.gme.fsG.fsP;
        aw cPy = com.tencent.mm.plugin.wallet_core.model.k.cPy();
        if (cPy != null) {
            this.nTZ.latitude = cPy.latitude;
            this.nTZ.longitude = cPy.longitude;
        }
        this.nTZ.wfc = str;
        AppMethodBeat.o(42148);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(42149);
        this.ehi = fVar;
        int a = a(eVar, this.gme, this);
        AppMethodBeat.o(42149);
        return a;
    }

    public final int getType() {
        return 1971;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(42150);
        ab.i(" NetSceneF2FLuckyMoneyInvalid", "errType %d,errCode %d,errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.nUa = (zw) ((com.tencent.mm.ai.b) qVar).fsH.fsP;
        this.kCl = this.nUa.kCl;
        this.kCm = this.nUa.kCm;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, this.nUa.kCl, this.nUa.kCm, this);
        }
        AppMethodBeat.o(42150);
    }
}
