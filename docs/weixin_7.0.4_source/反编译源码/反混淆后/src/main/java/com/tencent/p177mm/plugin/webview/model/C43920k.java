package com.tencent.p177mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.ael;
import com.tencent.p177mm.protocal.protobuf.aem;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.FilterEnum4Shaka;

/* renamed from: com.tencent.mm.plugin.webview.model.k */
public final class C43920k extends C1207m implements C1918k {
    private C1202f ehi;
    public final C7472b lty;

    public C43920k(String str, String str2) {
        AppMethodBeat.m2504i(6595);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ael();
        c1196a.fsK = new aem();
        c1196a.uri = "/cgi-bin/mmbiz-bin/getappticket";
        c1196a.fsI = FilterEnum4Shaka.MIC_WEISHI_v4_4_MEIWEI;
        this.lty = c1196a.acD();
        ael ael = (ael) this.lty.fsG.fsP;
        ael.csB = str;
        ael.signature = str2;
        AppMethodBeat.m2505o(6595);
    }

    public final int getType() {
        return FilterEnum4Shaka.MIC_WEISHI_v4_4_MEIWEI;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(6596);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.lty, this);
        AppMethodBeat.m2505o(6596);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(6597);
        C4990ab.m7416i("MicroMsg.NetSceneGetAppTicket", "errType = " + i2 + ", errCode = " + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(6597);
    }
}
