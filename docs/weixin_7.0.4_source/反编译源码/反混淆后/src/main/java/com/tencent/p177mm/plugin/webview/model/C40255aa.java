package com.tencent.p177mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bun;
import com.tencent.p177mm.protocal.protobuf.buo;

/* renamed from: com.tencent.mm.plugin.webview.model.aa */
public final class C40255aa extends C1207m implements C1918k {
    private C1202f eIc;
    public final C7472b ehh;

    public C40255aa(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.m2504i(6643);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bun();
        c1196a.fsK = new buo();
        c1196a.uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize";
        this.ehh = c1196a.acD();
        bun bun = (bun) this.ehh.fsG.fsP;
        bun.csB = str;
        bun.scope = str2;
        bun.state = str3;
        bun.wWd = str4;
        bun.wWe = str5;
        AppMethodBeat.m2505o(6643);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(6644);
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(6644);
    }

    public final int getType() {
        return 1388;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(6645);
        this.eIc = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(6645);
        return a;
    }
}
