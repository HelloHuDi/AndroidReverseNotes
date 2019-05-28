package com.tencent.p177mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p230g.p231a.C42006ig;
import com.tencent.p177mm.plugin.websearch.api.C22760s;
import com.tencent.p177mm.plugin.websearch.api.C7197a;
import com.tencent.p177mm.protocal.protobuf.axy;
import com.tencent.p177mm.protocal.protobuf.csu;
import com.tencent.p177mm.protocal.protobuf.csv;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.modelappbrand.q */
public final class C32813q extends C7197a implements C1918k {
    private C1202f eIc;
    private final C7472b fpJ;
    private csv fpK;
    private C22760s fpL;

    public C32813q(C22760s c22760s) {
        AppMethodBeat.m2504i(93736);
        this.fpL = c22760s;
        this.tZt = c22760s.cIv;
        this.tZu = c22760s.ctj;
        this.f1969Lp = c22760s.offset;
        this.gOW = c22760s.scene;
        this.tZv = c22760s.tZN;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new csu();
        c1196a.fsK = new csv();
        c1196a.uri = "/cgi-bin/mmbiz-bin/wxaapp/weappsearch";
        this.fpJ = c1196a.acD();
        csu csu = (csu) this.fpJ.fsG.fsP;
        axy abJ = C32813q.abJ();
        csu.jCt = c22760s.businessType;
        csu.wol = c22760s.ctj;
        csu.vOq = c22760s.offset;
        csu.vQg = c22760s.lcA;
        csu.wCv = c22760s.tZC;
        C42006ig c42006ig = new C42006ig();
        C4879a.xxA.mo10055m(c42006ig);
        csu.wCu = c42006ig.cDp.cDq;
        if (abJ != null) {
            csu.wCw = (double) abJ.vRp;
            csu.wCx = (double) abJ.vRq;
        }
        csu.wCy = C45445b.fpD;
        csu.xqd = c22760s.tZy;
        csu.xqe = c22760s.tZD;
        csu.xqf = c22760s.tZE;
        csu.xqb = C45445b.fpE;
        csu.wOI = c22760s.mDw;
        C4990ab.m7417i("MicroMsg.NetSceneWeAppSearch", "NetSceneWeAppSearch oreh SessionID : %s, KeywordID : %s, LocationX : %s, LocationY : %s", csu.wCy, csu.xqb, Double.valueOf(csu.wCw), Double.valueOf(csu.wCx));
        AppMethodBeat.m2505o(93736);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(93737);
        C4990ab.m7417i("MicroMsg.NetSceneWeAppSearch", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.fpK = (csv) this.fpJ.fsH.fsP;
        if (this.fpK != null) {
            C4990ab.m7419v("MicroMsg.NetSceneWeAppSearch", "return data\n%s", this.fpK.vOy);
        }
        if (this.eIc != null) {
            this.eIc.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(93737);
    }

    public final int getType() {
        return 1162;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(93738);
        C4990ab.m7416i("MicroMsg.NetSceneWeAppSearch", "doScene");
        this.eIc = c1202f;
        int a = mo4457a(c1902e, this.fpJ, this);
        AppMethodBeat.m2505o(93738);
        return a;
    }

    public final String abH() {
        return this.fpK != null ? this.fpK.vOy : "";
    }

    public final int abI() {
        return this.fpK != null ? this.fpK.wCB : 0;
    }

    private static axy abJ() {
        AppMethodBeat.m2504i(93739);
        try {
            String str = (String) C1720g.m3536RP().mo5239Ry().get(67591, null);
            if (str != null) {
                axy axy = new axy();
                String[] split = str.split(",");
                axy.wfG = Integer.valueOf(split[0]).intValue();
                axy.wfJ = Integer.valueOf(split[1]).intValue();
                axy.vRq = ((float) Integer.valueOf(split[2]).intValue()) / 1000000.0f;
                axy.vRp = ((float) Integer.valueOf(split[3]).intValue()) / 1000000.0f;
                C4990ab.m7417i("MicroMsg.NetSceneWeAppSearch", "lbs location is not null, %f, %f", Float.valueOf(axy.vRq), Float.valueOf(axy.vRp));
                AppMethodBeat.m2505o(93739);
                return axy;
            }
            C4990ab.m7416i("MicroMsg.NetSceneWeAppSearch", "lbs location is null, lbsContent is null!");
            AppMethodBeat.m2505o(93739);
            return null;
        } catch (Exception e) {
            C4990ab.m7417i("MicroMsg.NetSceneWeAppSearch", "lbs location is null, reason %s", e.getMessage());
            AppMethodBeat.m2505o(93739);
            return null;
        }
    }
}
