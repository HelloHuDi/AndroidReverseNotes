package com.tencent.p177mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.protocal.protobuf.C35908bw;
import com.tencent.p177mm.protocal.protobuf.C35909bx;

/* renamed from: com.tencent.mm.plugin.webview.model.g */
public final class C22892g extends C1207m implements C1918k {
    private C1202f eIc;
    public final C7472b ehh;

    public C22892g(String str, String str2, byte[] bArr) {
        AppMethodBeat.m2504i(6582);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C35908bw();
        c1196a.fsK = new C35909bx();
        c1196a.uri = "/cgi-bin/mmbiz-bin/oauth_addavatar";
        this.ehh = c1196a.acD();
        C35908bw c35908bw = (C35908bw) this.ehh.fsG.fsP;
        c35908bw.csB = str;
        c35908bw.nickname = str2;
        c35908bw.vEc = new C1332b(bArr);
        c35908bw.vEd = 0;
        AppMethodBeat.m2505o(6582);
    }

    public C22892g(String str, String str2, String str3) {
        AppMethodBeat.m2504i(6583);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C35908bw();
        c1196a.fsK = new C35909bx();
        c1196a.uri = "/cgi-bin/mmbiz-bin/oauth_addavatar";
        this.ehh = c1196a.acD();
        C35908bw c35908bw = (C35908bw) this.ehh.fsG.fsP;
        c35908bw.csB = str;
        c35908bw.nickname = str2;
        c35908bw.fileid = str3;
        c35908bw.vEd = 1;
        AppMethodBeat.m2505o(6583);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(6584);
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(6584);
    }

    public final int getType() {
        return 2500;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(6585);
        this.eIc = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(6585);
        return a;
    }
}
