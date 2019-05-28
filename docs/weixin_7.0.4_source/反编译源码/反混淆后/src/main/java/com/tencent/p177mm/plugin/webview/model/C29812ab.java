package com.tencent.p177mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bul;
import com.tencent.p177mm.protocal.protobuf.bum;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.webview.model.ab */
public final class C29812ab extends C1207m implements C1918k {
    private C1202f eIc;
    private final C7472b ehh;

    public C29812ab(int i, String str, String str2, String str3, LinkedList<String> linkedList) {
        AppMethodBeat.m2504i(6646);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bul();
        c1196a.fsK = new bum();
        c1196a.uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize_confirm";
        this.ehh = c1196a.acD();
        bul bul = (bul) this.ehh.fsG.fsP;
        bul.wII = i;
        bul.csB = str;
        bul.wIJ = linkedList;
        bul.state = str2;
        bul.wWc = str3;
        AppMethodBeat.m2505o(6646);
    }

    public C29812ab(String str, String str2, String str3, LinkedList<String> linkedList, int i) {
        AppMethodBeat.m2504i(6647);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bul();
        c1196a.fsK = new bum();
        c1196a.uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize_confirm";
        this.ehh = c1196a.acD();
        bul bul = (bul) this.ehh.fsG.fsP;
        bul.wII = 1;
        bul.csB = str;
        bul.wIJ = linkedList;
        bul.state = str2;
        bul.wWc = str3;
        bul.wcA = i;
        AppMethodBeat.m2505o(6647);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(6648);
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(6648);
    }

    public final bum cXC() {
        return (bum) this.ehh.fsH.fsP;
    }

    public final int getType() {
        return 1346;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(6649);
        this.eIc = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(6649);
        return a;
    }
}
