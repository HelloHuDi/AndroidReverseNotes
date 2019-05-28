package com.tencent.p177mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.cih;
import com.tencent.p177mm.protocal.protobuf.cii;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.webview.model.ac */
public final class C22875ac extends C1207m implements C1918k {
    private C1202f eIc;
    public final C7472b ehh;

    public C22875ac(String str, String str2) {
        AppMethodBeat.m2504i(6650);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cih();
        c1196a.fsK = new cii();
        c1196a.uri = "/cgi-bin/mmbiz-bin/transid";
        this.ehh = c1196a.acD();
        cih cih = (cih) this.ehh.fsG.fsP;
        cih.csB = str;
        cih.vGs = str2;
        AppMethodBeat.m2505o(6650);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(6651);
        C4990ab.m7417i("MicroMsg.NetSceneSendAppMsgToSpecifiedContact", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(6651);
    }

    public final int getType() {
        return 1142;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(6652);
        C4990ab.m7416i("MicroMsg.NetSceneSendAppMsgToSpecifiedContact", "doScene");
        this.eIc = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(6652);
        return a;
    }
}
