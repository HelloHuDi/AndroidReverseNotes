package com.tencent.p177mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C30234ve;
import com.tencent.p177mm.protocal.protobuf.C44180vf;

/* renamed from: com.tencent.mm.plugin.webview.model.i */
public final class C43918i extends C1207m implements C1918k {
    private C1202f eIc;
    private final C7472b ehh;

    public C43918i(int i) {
        AppMethodBeat.m2504i(6589);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C30234ve();
        c1196a.fsK = new C44180vf();
        c1196a.uri = "/cgi-bin/mmbiz-bin/oauth_delavatar";
        this.ehh = c1196a.acD();
        ((C30234ve) this.ehh.fsG.fsP).wcA = i;
        AppMethodBeat.m2505o(6589);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(6590);
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(6590);
    }

    public final int getType() {
        return 2700;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(6591);
        this.eIc = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(6591);
        return a;
    }
}
