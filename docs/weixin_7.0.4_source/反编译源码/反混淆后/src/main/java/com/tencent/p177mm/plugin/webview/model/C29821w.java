package com.tencent.p177mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.ber;
import com.tencent.p177mm.protocal.protobuf.bes;

/* renamed from: com.tencent.mm.plugin.webview.model.w */
public final class C29821w extends C1207m implements C1918k {
    private C1202f eIc;
    public final C7472b ehh;
    public Object tag;
    public String umb;

    public C29821w(String str, String str2, int i) {
        AppMethodBeat.m2504i(6631);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ber();
        c1196a.fsK = new bes();
        c1196a.uri = "/cgi-bin/mmbiz-bin/oauth_authorize";
        this.umb = str;
        this.ehh = c1196a.acD();
        ber ber = (ber) this.ehh.fsG.fsP;
        ber.wIH = str;
        ber.vNN = str2;
        ber.scene = i;
        AppMethodBeat.m2505o(6631);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(6632);
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(6632);
    }

    public final int getType() {
        return 1254;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(6633);
        this.eIc = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(6633);
        return a;
    }
}
