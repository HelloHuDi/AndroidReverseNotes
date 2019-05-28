package com.tencent.p177mm.plugin.recharge.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.wallet_core.model.mall.C40113c;
import com.tencent.p177mm.protocal.protobuf.acf;
import com.tencent.p177mm.protocal.protobuf.acg;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.recharge.model.c */
public final class C12955c extends C1207m implements C1918k {
    public String cFl;
    public C7472b ehh;
    private C1202f ehi;
    public String lcC;

    public C12955c(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.m2504i(44193);
        this.cFl = str2;
        this.lcC = str3;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new acf();
        c1196a.fsK = new acg();
        c1196a.uri = "/cgi-bin/mmpay-bin/flowdatarechargepreinquery";
        this.ehh = c1196a.acD();
        acf acf = (acf) this.ehh.fsG.fsP;
        acf.wjV = str;
        acf.vLs = str2;
        acf.pdB = str3;
        acf.wjW = str4;
        acf.wjX = str5;
        acf.wdB = C40113c.cQT().acH(str);
        AppMethodBeat.m2505o(44193);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(44194);
        C4990ab.m7410d("MicroMsg.NetSceneFlowDataRechargePreinQuery", "errCode " + i3 + ", errMsg " + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(44194);
    }

    public final int getType() {
        return 1555;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(44195);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(44195);
        return a;
    }
}
