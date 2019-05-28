package com.tencent.mm.plugin.wallet_core.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.biy;
import com.tencent.mm.protocal.protobuf.biz;
import com.tencent.mm.sdk.platformtools.ab;

public final class a extends m implements k {
    private b ehh;
    private f ehi;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        AppMethodBeat.i(46560);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new biy();
        aVar.fsK = new biz();
        aVar.uri = "/cgi-bin/mmpay-bin/payibgcheckjsapisign";
        this.ehh = aVar.acD();
        biy biy = (biy) this.ehh.fsG.fsP;
        biy.fKh = str;
        biy.vYP = str4;
        biy.vYO = str2;
        biy.vYQ = str5;
        biy.vYR = str6;
        biy.vLo = str3;
        biy.vXP = str7;
        AppMethodBeat.o(46560);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(46561);
        ab.i("MicroMsg.NetSceneIbgCheckJsapi", "check jsapi: errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        biz biz = (biz) ((b) qVar).fsH.fsP;
        if (i3 == 0 && i2 == 0) {
            i3 = biz.luT;
            str = biz.luU;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(46561);
    }

    public final int getType() {
        return 1767;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(46562);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(46562);
        return a;
    }
}
