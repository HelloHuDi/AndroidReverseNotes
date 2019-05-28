package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.yo;
import com.tencent.mm.protocal.protobuf.yp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.FilterEnum4Shaka;

public final class g extends m implements k {
    private final b ehh;
    private f ehi;

    public g(String str, int i, String str2) {
        AppMethodBeat.i(16572);
        ab.i("MicroMsg.NetSceneEnterTempSession", "NetSceneEnterTempSession %s, %s, %s", str, Integer.valueOf(i), str2);
        a aVar = new a();
        aVar.fsJ = new yo();
        aVar.fsK = new yp();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/entertempsession";
        aVar.fsI = FilterEnum4Shaka.MIC_WEISHI_FEIHONG;
        this.ehh = aVar.acD();
        String str3 = "";
        if (str2 == null) {
            str2 = str3;
        } else if (str2.length() > 32 && i != 19) {
            str2 = str2.substring(0, 32);
        }
        yo yoVar = (yo) this.ehh.fsG.fsP;
        yoVar.vMR = str;
        yoVar.vFH = i;
        yoVar.wer = com.tencent.mm.bt.b.akB(str2);
        yoVar.wcJ = com.tencent.mm.bt.b.bI(new byte[0]);
        ab.i("MicroMsg.NetSceneEnterTempSession", "NetSceneEnterTempSession %s, %s, %s", str, Integer.valueOf(i), Integer.valueOf(yoVar.wcJ.wR.length));
        AppMethodBeat.o(16572);
    }

    public final int getType() {
        return FilterEnum4Shaka.MIC_WEISHI_FEIHONG;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(16573);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(16573);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(16574);
        ab.i("MicroMsg.NetSceneEnterTempSession", "onGYNetEnd: %d, %d, %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(16574);
    }
}
