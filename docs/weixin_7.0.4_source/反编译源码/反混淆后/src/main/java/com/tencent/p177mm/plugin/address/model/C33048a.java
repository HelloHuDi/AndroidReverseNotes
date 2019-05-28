package com.tencent.p177mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C23459ww;
import com.tencent.p177mm.protocal.protobuf.C7558wv;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.address.model.a */
public final class C33048a extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;

    public C33048a(int i) {
        AppMethodBeat.m2504i(16722);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C7558wv();
        c1196a.fsK = new C23459ww();
        c1196a.uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/deleteinfo";
        this.ehh = c1196a.acD();
        C7558wv c7558wv = (C7558wv) this.ehh.fsG.fsP;
        c7558wv.wcQ = "invoice_info";
        c7558wv.wcR = i;
        c7558wv.cvd = 2;
        AppMethodBeat.m2505o(16722);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(16723);
        C4990ab.m7410d("MicroMsg.NetSceneDeleteUserAutoFillInfo", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            C4990ab.m7416i("MicroMsg.NetSceneDeleteUserAutoFillInfo", "");
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(16723);
    }

    public final int getType() {
        return 1194;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(16724);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(16724);
        return a;
    }
}
