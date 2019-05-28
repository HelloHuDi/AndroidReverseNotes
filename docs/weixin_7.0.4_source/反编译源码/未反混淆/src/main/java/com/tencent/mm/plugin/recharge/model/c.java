package com.tencent.mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.acf;
import com.tencent.mm.protocal.protobuf.acg;
import com.tencent.mm.sdk.platformtools.ab;

public final class c extends m implements k {
    public String cFl;
    public b ehh;
    private f ehi;
    public String lcC;

    public c(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(44193);
        this.cFl = str2;
        this.lcC = str3;
        a aVar = new a();
        aVar.fsJ = new acf();
        aVar.fsK = new acg();
        aVar.uri = "/cgi-bin/mmpay-bin/flowdatarechargepreinquery";
        this.ehh = aVar.acD();
        acf acf = (acf) this.ehh.fsG.fsP;
        acf.wjV = str;
        acf.vLs = str2;
        acf.pdB = str3;
        acf.wjW = str4;
        acf.wjX = str5;
        acf.wdB = com.tencent.mm.plugin.wallet_core.model.mall.c.cQT().acH(str);
        AppMethodBeat.o(44193);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(44194);
        ab.d("MicroMsg.NetSceneFlowDataRechargePreinQuery", "errCode " + i3 + ", errMsg " + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(44194);
    }

    public final int getType() {
        return 1555;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(44195);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(44195);
        return a;
    }
}
