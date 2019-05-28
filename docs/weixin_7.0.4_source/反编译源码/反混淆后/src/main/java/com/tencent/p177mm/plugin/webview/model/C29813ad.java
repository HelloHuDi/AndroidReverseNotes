package com.tencent.p177mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.azh;
import com.tencent.p177mm.protocal.protobuf.azm;
import com.tencent.p177mm.protocal.protobuf.azn;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.webview.model.ad */
public final class C29813ad extends C1207m implements C1918k {
    String appId;
    String czD;
    private C1202f eIc;
    final C7472b ehh;

    public C29813ad(String str, String str2, azh azh) {
        AppMethodBeat.m2504i(6653);
        this.appId = str;
        this.czD = str2;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new azm();
        c1196a.fsK = new azn();
        c1196a.uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_uploadcdninfo";
        this.ehh = c1196a.acD();
        azm azm = (azm) this.ehh.fsG.fsP;
        azm.csB = str;
        azm.wDv = azh;
        AppMethodBeat.m2505o(6653);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(6654);
        C4990ab.m7417i("MicroMsg.NetSceneUploadCdnInfo", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(6654);
    }

    public final int getType() {
        return 1034;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(6655);
        this.eIc = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(6655);
        return a;
    }
}
