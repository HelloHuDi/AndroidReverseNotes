package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.k.r;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bph;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class d extends m implements k {
    private b ehh;
    private f ehi;
    public int status;

    public d(String str, String str2, p pVar) {
        boolean z = true;
        AppMethodBeat.i(16731);
        a aVar = new a();
        aVar.fsJ = new bph();
        aVar.fsK = new bpi();
        aVar.uri = "/cgi-bin/micromsg-bin/rcptinfoimport";
        aVar.fsI = r.CTRL_INDEX;
        String str3 = "MicroMsg.NetSceneRcptInfoImportYiXun";
        StringBuilder append = new StringBuilder("a2key is ").append(!bo.isNullOrNil(str)).append(", newa2key is ");
        if (bo.isNullOrNil(str2)) {
            z = false;
        }
        ab.d(str3, append.append(z).toString());
        this.ehh = aVar.acD();
        bph bph = (bph) this.ehh.fsG.fsP;
        bph.vHP = new SKBuiltinBuffer_t().setBuffer(bo.anf(str));
        bph.wRL = new SKBuiltinBuffer_t().setBuffer(bo.anf(str2));
        bph.qq = pVar.intValue();
        AppMethodBeat.o(16731);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(16732);
        ab.d("MicroMsg.NetSceneRcptInfoImportYiXun", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            bpi bpi = (bpi) ((b) qVar).fsH.fsP;
            this.status = bpi.wRM;
            ab.d("MicroMsg.NetSceneRcptInfoImportYiXun", "status : " + this.status);
            if (bpi.wRK.wRN != null && this.status == 0) {
                ab.d("MicroMsg.NetSceneRcptInfoImportYiXun", "resp.rImpl.rcptinfolist.rcptinfolist " + bpi.wRK.wRN.size());
                com.tencent.mm.plugin.address.a.a.arQ();
                com.tencent.mm.plugin.address.a.a.arS().s(bpi.wRK.wRN);
                com.tencent.mm.plugin.address.a.a.arQ();
                com.tencent.mm.plugin.address.a.a.arS().arU();
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(16732);
    }

    public final int getType() {
        return r.CTRL_INDEX;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(16733);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(16733);
        return a;
    }
}
