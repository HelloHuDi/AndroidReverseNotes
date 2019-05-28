package com.tencent.p177mm.wallet_core.p649c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bll;
import com.tencent.p177mm.protocal.protobuf.blm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.wxmm.v2helper;

/* renamed from: com.tencent.mm.wallet_core.c.s */
public final class C46721s extends C36378u {
    public final C7472b ehh;
    private C1202f ehi;
    public String kWz;
    public String tQX;
    public String tQY;

    public C46721s(String str, String str2, String str3, int i, int i2, String str4) {
        AppMethodBeat.m2504i(49077);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bll();
        c1196a.fsK = new blm();
        c1196a.uri = "/cgi-bin/micromsg-bin/preparepurchase";
        c1196a.fsI = v2helper.EMethodOutputVolumeGainEnable;
        this.ehh = c1196a.acD();
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
        C4990ab.m7410d("MicroMsg.NetScenePreparePurchase", "productId:" + str + ",price:" + str2 + ",currencyType:" + str3 + ",payType:" + i2);
        AppMethodBeat.m2505o(49077);
    }

    /* renamed from: e */
    public final void mo9541e(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(49078);
        C4990ab.m7412e("MicroMsg.NetScenePreparePurchase", "ErrType:" + i + ",errCode:" + i2 + ",errMsg:" + str);
        if (i == 0 && i2 == 0) {
            this.ehi.onSceneEnd(i, i2, str, this);
            AppMethodBeat.m2505o(49078);
            return;
        }
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.m2505o(49078);
    }

    public final int getType() {
        return v2helper.EMethodOutputVolumeGainEnable;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(49079);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(49079);
        return a;
    }
}
