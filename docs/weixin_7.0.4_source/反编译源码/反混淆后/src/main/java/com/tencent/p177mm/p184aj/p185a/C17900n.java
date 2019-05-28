package com.tencent.p177mm.p184aj.p185a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C30231uo;
import com.tencent.p177mm.protocal.protobuf.C40579un;
import com.tencent.p177mm.protocal.protobuf.acr;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.aj.a.n */
public final class C17900n extends C1207m implements C1918k {
    Object data;
    public C7472b ehh;
    private C1202f ehi;

    public C17900n(String str, acr acr, Object obj) {
        AppMethodBeat.m2504i(11612);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C40579un();
        c1196a.fsK = new C30231uo();
        c1196a.uri = "/cgi-bin/mmocbiz-bin/createbizchatinfo";
        this.ehh = c1196a.acD();
        C40579un c40579un = (C40579un) this.ehh.fsG.fsP;
        c40579un.vNb = str;
        c40579un.wcb = acr;
        this.data = obj;
        AppMethodBeat.m2505o(11612);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(11613);
        C4990ab.m7411d("MicroMsg.brandservice.NetSceneCreateBizChatInfo", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(11613);
    }

    public final int getType() {
        return 1355;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(11614);
        this.ehi = c1202f;
        C4990ab.m7416i("MicroMsg.brandservice.NetSceneCreateBizChatInfo", "do scene");
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(11614);
        return a;
    }

    public final C30231uo afm() {
        if (this.ehh == null || this.ehh.fsH.fsP == null) {
            return null;
        }
        return (C30231uo) this.ehh.fsH.fsP;
    }

    public final C40579un afn() {
        if (this.ehh == null || this.ehh.fsG.fsP == null) {
            return null;
        }
        return (C40579un) this.ehh.fsG.fsP;
    }
}
