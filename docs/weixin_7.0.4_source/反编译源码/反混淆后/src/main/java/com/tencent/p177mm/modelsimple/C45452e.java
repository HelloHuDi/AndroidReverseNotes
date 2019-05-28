package com.tencent.p177mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.protocal.protobuf.C23455we;
import com.tencent.p177mm.protocal.protobuf.C44186wd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.FilterEnum4Shaka;

/* renamed from: com.tencent.mm.modelsimple.e */
public final class C45452e extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;

    public C45452e(String str) {
        AppMethodBeat.m2504i(16564);
        C4990ab.m7417i("MicroMsg.NetSceneDelTempSession", "NetSceneDelTempSession %s", str);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C44186wd();
        c1196a.fsK = new C23455we();
        c1196a.uri = "/cgi-bin/mmbiz-bin/usrmsg/deltempsession";
        c1196a.fsI = FilterEnum4Shaka.MIC_WEISHI_SHIZI;
        this.ehh = c1196a.acD();
        C44186wd c44186wd = (C44186wd) this.ehh.fsG.fsP;
        c44186wd.vMR = str;
        c44186wd.wcJ = C1332b.m2847bI(new byte[0]);
        AppMethodBeat.m2505o(16564);
    }

    public final int getType() {
        return FilterEnum4Shaka.MIC_WEISHI_SHIZI;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(16565);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(16565);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(16566);
        C4990ab.m7417i("MicroMsg.NetSceneDelTempSession", "onGYNetEnd: %d, %d, %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(16566);
    }
}
