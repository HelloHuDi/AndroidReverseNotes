package com.tencent.p177mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.azi;
import com.tencent.p177mm.protocal.protobuf.azj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.webview.model.j */
public final class C43919j extends C1207m implements C1918k {
    String appId;
    private C1202f eIc;
    final C7472b ehh;
    String hep;

    public C43919j(String str, String str2) {
        AppMethodBeat.m2504i(6592);
        this.appId = str;
        this.hep = str2;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new azi();
        c1196a.fsK = new azj();
        c1196a.uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_downloadcdninfo";
        this.ehh = c1196a.acD();
        azi azi = (azi) this.ehh.fsG.fsP;
        azi.csB = str;
        azi.wDu = str2;
        C4990ab.m7417i("MicroMsg.NetSceneDownloadCdnInfo", "download cdn info, appid : %s, mediaId : %s", str, str2);
        AppMethodBeat.m2505o(6592);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(6593);
        C4990ab.m7417i("MicroMsg.NetSceneDownloadCdnInfo", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(6593);
    }

    public final int getType() {
        return 1035;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(6594);
        this.eIc = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(6594);
        return a;
    }
}
