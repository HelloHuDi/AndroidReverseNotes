package com.tencent.p177mm.plugin.ext.p730c.p963a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C23432qs;
import com.tencent.p177mm.protocal.protobuf.C30218qr;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.ext.c.a.a */
public final class C11772a extends C1207m implements C1918k {
    private C7472b ehh;
    public C1202f ehi;
    public int lRf = -1;
    public String mUrl = null;

    public C11772a(String str, int i, int i2) {
        AppMethodBeat.m2504i(20431);
        this.mUrl = str;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C30218qr();
        c1196a.fsK = new C23432qs();
        c1196a.uri = "/cgi-bin/micromsg-bin/checkcamerascan";
        c1196a.fsI = 782;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        C4990ab.m7417i("MicroMsg.NetSceneCheckUrlAvailableInWx", "hy: checking url: %s", str);
        C30218qr c30218qr = (C30218qr) this.ehh.fsG.fsP;
        c30218qr.URL = this.mUrl;
        c30218qr.vXI = i;
        c30218qr.vXJ = i2;
        AppMethodBeat.m2505o(20431);
    }

    public final int getType() {
        return 782;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(20432);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(20432);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(20433);
        C4990ab.m7411d("MicroMsg.NetSceneCheckUrlAvailableInWx", "hy: on get camera url end. errType; %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        C23432qs c23432qs = (C23432qs) ((C7472b) c1929q).fsH.fsP;
        if (i2 == 0 && i3 == 0) {
            this.lRf = c23432qs.jCt;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(20433);
    }
}
