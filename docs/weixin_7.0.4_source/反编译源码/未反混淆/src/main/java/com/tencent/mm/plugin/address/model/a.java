package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.wv;
import com.tencent.mm.protocal.protobuf.ww;
import com.tencent.mm.sdk.platformtools.ab;

public final class a extends m implements k {
    private b ehh;
    private f ehi;

    public a(int i) {
        AppMethodBeat.i(16722);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new wv();
        aVar.fsK = new ww();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/deleteinfo";
        this.ehh = aVar.acD();
        wv wvVar = (wv) this.ehh.fsG.fsP;
        wvVar.wcQ = "invoice_info";
        wvVar.wcR = i;
        wvVar.cvd = 2;
        AppMethodBeat.o(16722);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(16723);
        ab.d("MicroMsg.NetSceneDeleteUserAutoFillInfo", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            ab.i("MicroMsg.NetSceneDeleteUserAutoFillInfo", "");
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(16723);
    }

    public final int getType() {
        return 1194;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(16724);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(16724);
        return a;
    }
}
