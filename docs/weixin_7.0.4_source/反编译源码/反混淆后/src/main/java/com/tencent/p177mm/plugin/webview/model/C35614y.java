package com.tencent.p177mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bna;
import com.tencent.p177mm.protocal.protobuf.bnb;

/* renamed from: com.tencent.mm.plugin.webview.model.y */
public final class C35614y extends C1207m implements C1918k {
    private C1202f eIc;
    public final C7472b ehh;

    public C35614y(String str) {
        AppMethodBeat.m2504i(6637);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bna();
        c1196a.fsK = new bnb();
        c1196a.uri = "/cgi-bin/mmbiz-bin/qrconnect_authorize";
        this.ehh = c1196a.acD();
        ((bna) this.ehh.fsG.fsP).wIH = str;
        AppMethodBeat.m2505o(6637);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(6638);
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(6638);
    }

    public final int getType() {
        return 2543;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(6639);
        this.eIc = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(6639);
        return a;
    }
}
