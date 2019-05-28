package com.tencent.p177mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.address.p1467a.C33045a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C42526r;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.bph;
import com.tencent.p177mm.protocal.protobuf.bpi;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.address.model.d */
public final class C42319d extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    public int status;

    public C42319d(String str, String str2, C1183p c1183p) {
        boolean z = true;
        AppMethodBeat.m2504i(16731);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bph();
        c1196a.fsK = new bpi();
        c1196a.uri = "/cgi-bin/micromsg-bin/rcptinfoimport";
        c1196a.fsI = C42526r.CTRL_INDEX;
        String str3 = "MicroMsg.NetSceneRcptInfoImportYiXun";
        StringBuilder append = new StringBuilder("a2key is ").append(!C5046bo.isNullOrNil(str)).append(", newa2key is ");
        if (C5046bo.isNullOrNil(str2)) {
            z = false;
        }
        C4990ab.m7410d(str3, append.append(z).toString());
        this.ehh = c1196a.acD();
        bph bph = (bph) this.ehh.fsG.fsP;
        bph.vHP = new SKBuiltinBuffer_t().setBuffer(C5046bo.anf(str));
        bph.wRL = new SKBuiltinBuffer_t().setBuffer(C5046bo.anf(str2));
        bph.f2103qq = c1183p.intValue();
        AppMethodBeat.m2505o(16731);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(16732);
        C4990ab.m7410d("MicroMsg.NetSceneRcptInfoImportYiXun", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            bpi bpi = (bpi) ((C7472b) c1929q).fsH.fsP;
            this.status = bpi.wRM;
            C4990ab.m7410d("MicroMsg.NetSceneRcptInfoImportYiXun", "status : " + this.status);
            if (bpi.wRK.wRN != null && this.status == 0) {
                C4990ab.m7410d("MicroMsg.NetSceneRcptInfoImportYiXun", "resp.rImpl.rcptinfolist.rcptinfolist " + bpi.wRK.wRN.size());
                C33045a.arQ();
                C33045a.arS().mo67844s(bpi.wRK.wRN);
                C33045a.arQ();
                C33045a.arS().arU();
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(16732);
    }

    public final int getType() {
        return C42526r.CTRL_INDEX;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(16733);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(16733);
        return a;
    }
}
