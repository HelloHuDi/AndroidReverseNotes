package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aqn;
import com.tencent.mm.protocal.protobuf.aqo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class f extends m implements k {
    private b ehh = null;
    private com.tencent.mm.ai.f ehi;
    private aqn nyp = null;
    public aqo nyq = null;
    public boolean nyr = true;

    public f(String str, String str2) {
        AppMethodBeat.i(21851);
        if (bo.isNullOrNil(str2)) {
            this.nyr = true;
            str2 = "";
        } else {
            this.nyr = false;
        }
        a aVar = new a();
        aVar.fsJ = new aqn();
        aVar.fsK = new aqo();
        aVar.fsI = 929;
        aVar.uri = "/cgi-bin/micromsg-bin/getwcoproductlist";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        this.nyp = (aqn) this.ehh.fsG.fsP;
        this.nyp.wuk = str;
        this.nyp.wul = str2;
        ab.i("MicroMsg.NetSceneIPCallGetProductList", "NetSceneIPCallGetProductList");
        AppMethodBeat.o(21851);
    }

    public final int getType() {
        return 929;
    }

    public final int a(e eVar, com.tencent.mm.ai.f fVar) {
        AppMethodBeat.i(21852);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(21852);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(21853);
        ab.i("MicroMsg.NetSceneIPCallGetProductList", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nyq = (aqo) ((b) qVar).fsH.fsP;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(21853);
    }
}
