package com.tencent.p177mm.plugin.ipcall.p438a.p732d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.aqn;
import com.tencent.p177mm.protocal.protobuf.aqo;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.ipcall.a.d.f */
public final class C34372f extends C1207m implements C1918k {
    private C7472b ehh = null;
    private C1202f ehi;
    private aqn nyp = null;
    public aqo nyq = null;
    public boolean nyr = true;

    public C34372f(String str, String str2) {
        AppMethodBeat.m2504i(21851);
        if (C5046bo.isNullOrNil(str2)) {
            this.nyr = true;
            str2 = "";
        } else {
            this.nyr = false;
        }
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aqn();
        c1196a.fsK = new aqo();
        c1196a.fsI = 929;
        c1196a.uri = "/cgi-bin/micromsg-bin/getwcoproductlist";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        this.nyp = (aqn) this.ehh.fsG.fsP;
        this.nyp.wuk = str;
        this.nyp.wul = str2;
        C4990ab.m7416i("MicroMsg.NetSceneIPCallGetProductList", "NetSceneIPCallGetProductList");
        AppMethodBeat.m2505o(21851);
    }

    public final int getType() {
        return 929;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(21852);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(21852);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(21853);
        C4990ab.m7417i("MicroMsg.NetSceneIPCallGetProductList", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nyq = (aqo) ((C7472b) c1929q).fsH.fsP;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(21853);
    }
}
