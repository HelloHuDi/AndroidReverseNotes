package com.tencent.mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.g.a.ig;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.websearch.api.a;
import com.tencent.mm.plugin.websearch.api.s;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.csu;
import com.tencent.mm.protocal.protobuf.csv;
import com.tencent.mm.sdk.platformtools.ab;

public final class q extends a implements k {
    private f eIc;
    private final b fpJ;
    private csv fpK;
    private s fpL;

    public q(s sVar) {
        AppMethodBeat.i(93736);
        this.fpL = sVar;
        this.tZt = sVar.cIv;
        this.tZu = sVar.ctj;
        this.Lp = sVar.offset;
        this.gOW = sVar.scene;
        this.tZv = sVar.tZN;
        b.a aVar = new b.a();
        aVar.fsJ = new csu();
        aVar.fsK = new csv();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/weappsearch";
        this.fpJ = aVar.acD();
        csu csu = (csu) this.fpJ.fsG.fsP;
        axy abJ = abJ();
        csu.jCt = sVar.businessType;
        csu.wol = sVar.ctj;
        csu.vOq = sVar.offset;
        csu.vQg = sVar.lcA;
        csu.wCv = sVar.tZC;
        ig igVar = new ig();
        com.tencent.mm.sdk.b.a.xxA.m(igVar);
        csu.wCu = igVar.cDp.cDq;
        if (abJ != null) {
            csu.wCw = (double) abJ.vRp;
            csu.wCx = (double) abJ.vRq;
        }
        csu.wCy = b.fpD;
        csu.xqd = sVar.tZy;
        csu.xqe = sVar.tZD;
        csu.xqf = sVar.tZE;
        csu.xqb = b.fpE;
        csu.wOI = sVar.mDw;
        ab.i("MicroMsg.NetSceneWeAppSearch", "NetSceneWeAppSearch oreh SessionID : %s, KeywordID : %s, LocationX : %s, LocationY : %s", csu.wCy, csu.xqb, Double.valueOf(csu.wCw), Double.valueOf(csu.wCx));
        AppMethodBeat.o(93736);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        AppMethodBeat.i(93737);
        ab.i("MicroMsg.NetSceneWeAppSearch", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.fpK = (csv) this.fpJ.fsH.fsP;
        if (this.fpK != null) {
            ab.v("MicroMsg.NetSceneWeAppSearch", "return data\n%s", this.fpK.vOy);
        }
        if (this.eIc != null) {
            this.eIc.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(93737);
    }

    public final int getType() {
        return 1162;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(93738);
        ab.i("MicroMsg.NetSceneWeAppSearch", "doScene");
        this.eIc = fVar;
        int a = a(eVar, this.fpJ, this);
        AppMethodBeat.o(93738);
        return a;
    }

    public final String abH() {
        return this.fpK != null ? this.fpK.vOy : "";
    }

    public final int abI() {
        return this.fpK != null ? this.fpK.wCB : 0;
    }

    private static axy abJ() {
        AppMethodBeat.i(93739);
        try {
            String str = (String) g.RP().Ry().get(67591, null);
            if (str != null) {
                axy axy = new axy();
                String[] split = str.split(",");
                axy.wfG = Integer.valueOf(split[0]).intValue();
                axy.wfJ = Integer.valueOf(split[1]).intValue();
                axy.vRq = ((float) Integer.valueOf(split[2]).intValue()) / 1000000.0f;
                axy.vRp = ((float) Integer.valueOf(split[3]).intValue()) / 1000000.0f;
                ab.i("MicroMsg.NetSceneWeAppSearch", "lbs location is not null, %f, %f", Float.valueOf(axy.vRq), Float.valueOf(axy.vRp));
                AppMethodBeat.o(93739);
                return axy;
            }
            ab.i("MicroMsg.NetSceneWeAppSearch", "lbs location is null, lbsContent is null!");
            AppMethodBeat.o(93739);
            return null;
        } catch (Exception e) {
            ab.i("MicroMsg.NetSceneWeAppSearch", "lbs location is null, reason %s", e.getMessage());
            AppMethodBeat.o(93739);
            return null;
        }
    }
}
