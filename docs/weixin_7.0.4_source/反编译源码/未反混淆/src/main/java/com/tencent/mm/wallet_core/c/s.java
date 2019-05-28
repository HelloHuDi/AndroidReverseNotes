package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bll;
import com.tencent.mm.protocal.protobuf.blm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.wxmm.v2helper;

public final class s extends u {
    public final b ehh;
    private f ehi;
    public String kWz;
    public String tQX;
    public String tQY;

    public s(String str, String str2, String str3, int i, int i2, String str4) {
        AppMethodBeat.i(49077);
        a aVar = new a();
        aVar.fsJ = new bll();
        aVar.fsK = new blm();
        aVar.uri = "/cgi-bin/micromsg-bin/preparepurchase";
        aVar.fsI = v2helper.EMethodOutputVolumeGainEnable;
        this.ehh = aVar.acD();
        bll bll = (bll) this.ehh.fsG.fsP;
        this.kWz = str;
        bll.ProductID = str;
        this.tQY = str2;
        bll.wOs = str2;
        this.tQX = str3;
        bll.wOt = str3;
        bll.pdc = i2;
        bll.wOu = i;
        bll.ndT = str4;
        ab.d("MicroMsg.NetScenePreparePurchase", "productId:" + str + ",price:" + str2 + ",currencyType:" + str3 + ",payType:" + i2);
        AppMethodBeat.o(49077);
    }

    public final void e(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(49078);
        ab.e("MicroMsg.NetScenePreparePurchase", "ErrType:" + i + ",errCode:" + i2 + ",errMsg:" + str);
        if (i == 0 && i2 == 0) {
            this.ehi.onSceneEnd(i, i2, str, this);
            AppMethodBeat.o(49078);
            return;
        }
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.o(49078);
    }

    public final int getType() {
        return v2helper.EMethodOutputVolumeGainEnable;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(49079);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(49079);
        return a;
    }
}
