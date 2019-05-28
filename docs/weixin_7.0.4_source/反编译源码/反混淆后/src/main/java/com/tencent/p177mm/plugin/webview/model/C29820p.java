package com.tencent.p177mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.avl;
import com.tencent.p177mm.protocal.protobuf.avm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.webview.model.p */
public final class C29820p extends C1207m implements C1918k {
    private C1202f eIc;
    public final C7472b ehh;

    public C29820p(String str, String str2) {
        AppMethodBeat.m2504i(6610);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new avl();
        c1196a.fsK = new avm();
        c1196a.uri = "/cgi-bin/mmpay-bin/payibggetuseropenid";
        this.ehh = c1196a.acD();
        avl avl = (avl) this.ehh.fsG.fsP;
        avl.jBB = str2;
        avl.fKh = str;
        AppMethodBeat.m2505o(6610);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(6611);
        C4990ab.m7417i("MicroMsg.NetSceneGetUserOpenId", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(6611);
    }

    public final int getType() {
        return 1566;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(6612);
        C4990ab.m7416i("MicroMsg.NetSceneGetUserOpenId", "doScene");
        this.eIc = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(6612);
        return a;
    }
}
