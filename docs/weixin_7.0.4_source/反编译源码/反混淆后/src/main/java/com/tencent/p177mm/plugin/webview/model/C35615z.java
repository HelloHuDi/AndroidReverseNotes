package com.tencent.p177mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bmy;
import com.tencent.p177mm.protocal.protobuf.bmz;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.webview.model.z */
public final class C35615z extends C1207m implements C1918k {
    private C1202f eIc;
    private final C7472b ehh;

    public C35615z(int i, String str, LinkedList<String> linkedList, int i2) {
        AppMethodBeat.m2504i(6640);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bmy();
        c1196a.fsK = new bmz();
        c1196a.uri = "/cgi-bin/mmbiz-bin/qrconnect_authorize_confirm";
        this.ehh = c1196a.acD();
        bmy bmy = (bmy) this.ehh.fsG.fsP;
        bmy.wII = i;
        bmy.wIH = str;
        bmy.wIJ = linkedList;
        bmy.wcA = i2;
        AppMethodBeat.m2505o(6640);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(6641);
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(6641);
    }

    public final int getType() {
        return 1137;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(6642);
        this.eIc = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(6642);
        return a;
    }
}
