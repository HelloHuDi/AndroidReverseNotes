package com.tencent.p177mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C35907bv;
import com.tencent.p177mm.protocal.protobuf.C40505bu;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.webview.model.h */
public final class C43917h extends C1207m implements C1918k {
    private C1202f eIc;
    public final C7472b ehh;
    public String mnu;

    public C43917h(String str, String str2, String str3) {
        AppMethodBeat.m2504i(6586);
        this.mnu = str3;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C40505bu();
        c1196a.fsK = new C35907bv();
        c1196a.uri = "/cgi-bin/mmbiz-bin/oauth_addavatarheadimg";
        this.ehh = c1196a.acD();
        C40505bu c40505bu = (C40505bu) this.ehh.fsG.fsP;
        c40505bu.vEb = str;
        c40505bu.csB = str2;
        AppMethodBeat.m2505o(6586);
    }

    public final int getType() {
        return 2667;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(6587);
        this.eIc = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(6587);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(6588);
        C4990ab.m7417i("MicroMsg.NetSceneCreateAvatar", "NetSceneCreateAvatar:  netId = %d, errType = %d,errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.eIc != null) {
            this.eIc.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(6588);
    }
}
